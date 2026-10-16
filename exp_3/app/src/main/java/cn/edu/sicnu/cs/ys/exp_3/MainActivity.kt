package cn.edu.sicnu.cs.ys.exp_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var etMainInput: EditText
    private lateinit var tvBackResult: TextView

    // 接收ThirdActivity返回的数据
    private val requestLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data?.getStringExtra("return_msg")
            tvBackResult.text = getString(R.string.text_back_result) + data
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMainInput = findViewById(R.id.et_main_input)
        tvBackResult = findViewById(R.id.tv_back_result)

        val btnSecond:Button = findViewById(R.id.btn_second)
        val btnThird:Button = findViewById(R.id.btn_third)
        val btnFourth:Button = findViewById(R.id.btn_fourth)
        val btnFifth:Button = findViewById(R.id.btn_fifth)

        // (1) SecondActivity：正向传参
        btnSecond.setOnClickListener {
            val text = etMainInput.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("send_msg", text)
            startActivity(intent)
        }

        // (2) ThirdActivity：返回数据给Main
        btnThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            requestLauncher.launch(intent)
        }

        // (3) FourthActivity：隐式相机拍照
        btnFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }

        // (4) FifthActivity：秒表
        btnFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
    }
}

