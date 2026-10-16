package cn.edu.sicnu.cs.ys.exp_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class FifthActivity : AppCompatActivity() {
    private lateinit var tvTime: TextView
    private var timeCount = 0L
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable {
        override fun run() {
            if(isRunning){
                timeCount += 100
                val second = timeCount /1000
                val ms = (timeCount %1000)/100
                tvTime.text = String.format("%02d.%d", second, ms)
                handler.postDelayed(this, 100)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        tvTime = findViewById(R.id.tv_stopwatch)
        val btnStart:Button = findViewById(R.id.btn_start)
        val btnStop:Button = findViewById(R.id.btn_stop)
        val btnReset:Button = findViewById(R.id.btn_reset)

        // 横竖屏旋转，恢复保存的计时数据
        if(savedInstanceState != null){
            timeCount = savedInstanceState.getLong("time")
            isRunning = savedInstanceState.getBoolean("running")
            if(isRunning){
                handler.post(runnable)
            }
        }

        btnStart.setOnClickListener {
            if(!isRunning){
                isRunning = true
                handler.post(runnable)
            }
        }
        btnStop.setOnClickListener {
            isRunning = false
        }
        btnReset.setOnClickListener {
            isRunning = false
            timeCount = 0L
            tvTime.text = "00.0"
        }
    }

    // 保存状态：旋转屏幕时保存计时变量
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("time", timeCount)
        outState.putBoolean("running", isRunning)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}
