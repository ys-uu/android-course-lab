package cn.edu.sicnu.cs.ys.exp_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val etInput:EditText = findViewById(R.id.et_back_input)
        val btnBack:Button = findViewById(R.id.btn_back_main)

        btnBack.setOnClickListener {
            val returnText = etInput.text.toString()
            val intent = Intent().apply {
                putExtra("return_msg", returnText)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
