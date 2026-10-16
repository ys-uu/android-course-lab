package cn.edu.sicnu.cs.ys.exp_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val tvReceive:TextView = findViewById(R.id.tv_receive)
        val msg = intent.getStringExtra("send_msg")
        tvReceive.text = getString(R.string.text_receive) + msg
    }
}
