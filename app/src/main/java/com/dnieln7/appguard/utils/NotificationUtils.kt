package com.dnieln7.appguard.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import com.dnieln7.appguard.MainActivity
import com.dnieln7.appguard.R

class NotificationUtils(context: Context) : ContextWrapper(context) {

    private val guardServiceId = "com.dnieln7.appguard.GUARD"
    private val guardService = "Guard Service"

    init {
        createNotificationsChannel()
    }

    private fun getManager(): NotificationManager {
        return getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun createNotificationsChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val stepsChannel = NotificationChannel(
                guardServiceId,
                guardService,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            stepsChannel.enableVibration(true)
            stepsChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

            getManager().createNotificationChannel(stepsChannel)
        }
    }

    fun guardServiceNotification(): Notification {
        val notification: Notification

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val builder = Notification.Builder(this, guardServiceId)

            notification = builder
                .setContentIntent(pendingIntent)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Service running...")
                .setSmallIcon(R.drawable.ic_logo)
                .build()

        } else {
            val builder = NotificationCompat.Builder(this, guardServiceId)

            notification = builder
                .setContentIntent(pendingIntent)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Service running...")
                .setSmallIcon(R.drawable.ic_logo)
                .build()
        }

        return notification
    }

    fun launch(notification: Notification, code: Int = 100) {
        NotificationManagerCompat.from(this).notify(code, notification)
    }
}