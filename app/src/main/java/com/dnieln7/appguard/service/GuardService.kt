package com.dnieln7.appguard.service

import android.app.Service
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.dnieln7.appguard.utils.NotificationUtils
import com.dnieln7.appguard.utils.toastShort
import kotlinx.coroutines.*
import java.util.*

class GuardService : Service() {

    private lateinit var notificationUtils: NotificationUtils
    private lateinit var guardJob: Job

    private lateinit var manager: UsageStatsManager

    override fun onCreate() {
        super.onCreate()

        notificationUtils = NotificationUtils(this)
        manager = getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

        guardJob = CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                val time = System.currentTimeMillis()

                val stats = manager.queryUsageStats(
                    UsageStatsManager.INTERVAL_DAILY,
                    time - 10000L,
                    time
                )

                println(stats?.size)

                if (stats != null) {
                    val mySortedMap: SortedMap<Long, UsageStats> = TreeMap()
                    for (usageStats in stats) {
                        mySortedMap[usageStats.lastTimeUsed] = usageStats
                    }

                    if (!mySortedMap.isEmpty()) {
                        val topPackageName = mySortedMap[mySortedMap.lastKey()]?.packageName

                        withContext(Dispatchers.Main) {
                            applicationContext.toastShort("$topPackageName")
                        }
                    }
                }

                delay(2000)
            }
        }

        IS_RUNNING = true
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = notificationUtils.guardServiceNotification()

        startForeground(SERVICE_ID, notification)

        return START_STICKY
    }

    override fun onDestroy() {
        guardJob.cancel()
        IS_RUNNING = false

        super.onDestroy()
    }

    companion object {
        const val SERVICE_ID = 1
        var IS_RUNNING = false
    }
}