package cn.edu.sicnu.cs.ys.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMsg:TextView = findViewById(R.id.tv_msg)
        val btnClick:Button = findViewById(R.id.btn_click)

        btnClick.setOnClickListener {
            tvMsg.text = getString(R.string.clicked_text)
        }
    }
}
