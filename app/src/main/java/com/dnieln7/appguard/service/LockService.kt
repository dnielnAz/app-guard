package com.dnieln7.appguard.service

import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.*
import android.widget.TextView
import com.dnieln7.appguard.databinding.FloatingWindowLockBinding
import com.dnieln7.appguard.utils.toastShort

class LockService : Service() {

    private lateinit var binding: FloatingWindowLockBinding
    private lateinit var layoutParams: WindowManager.LayoutParams
    private lateinit var windowManager: WindowManager

    private var type: Int? = null

    override fun onCreate() {
        super.onCreate()

        val metrics = applicationContext.resources.displayMetrics
        val width = metrics.widthPixels
        val height = metrics.heightPixels

        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val inflater = baseContext.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater

        binding = FloatingWindowLockBinding.inflate(inflater)

        type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_TOAST
        }

        layoutParams = WindowManager.LayoutParams(
            (width * 1F).toInt(),
            (height * 1F).toInt(),
            type!!,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )

        layoutParams.gravity = Gravity.CENTER
        layoutParams.x = 0
        layoutParams.y = 0

        windowManager.addView(binding.root, layoutParams)

        initKeys()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun initKeys() {
        with(binding) {
            key9.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key8.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key7.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key6.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key5.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key4.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key3.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key2.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key1.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            key0.setOnClickListener {
                if (code.text.toString().length < 4) {
                    code.text = code.text.toString().plus((it as TextView).text.toString())
                }
            }
            keyDone.setOnClickListener {
                if (code.text.toString() == "1010") {
                    applicationContext.toastShort("Success")
                    close()
                } else {
                    applicationContext.toastShort("Wrong password")
                }
            }
            keyDelete.setOnClickListener {
                if (code.text.toString().length == 1) {
                    code.text = ""
                }
                if (code.text.toString().length > 1) {
                    code.text = code.text.toString().dropLast(1)
                }
            }
        }
    }

    private fun enableDraggable() {
        binding.root.setOnTouchListener(object : View.OnTouchListener {
            val updatedLayoutParams = layoutParams
            var x = 0.0
            var y = 0.0
            var px = 0.0
            var py = 0.0

            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                event?.also {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            x = updatedLayoutParams.x.toDouble()
                            y = updatedLayoutParams.y.toDouble()

                            px = event.rawX.toDouble()
                            py = event.rawY.toDouble()
                        }
                        MotionEvent.ACTION_MOVE -> {
                            updatedLayoutParams.x = (x + event.rawX - px).toInt()
                            updatedLayoutParams.y = (y + event.rawY - py).toInt()

                            windowManager.updateViewLayout(binding.root, updatedLayoutParams)
                        }
                    }
                }

                return false
            }
        })
    }

    fun close() {
        stopSelf()
        windowManager.removeView(binding.root)
    }
}