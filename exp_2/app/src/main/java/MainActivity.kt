package cn.edu.sicnu.cs.ys.exp_2

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var model: ProgramAdviserModel

    private lateinit var btnAddTv: Button
    private lateinit var llContainer: LinearLayout
    private lateinit var btnConfirm: Button
    private lateinit var spLanguage: Spinner
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ProgramAdviserModel()

        // 绑定控件
        btnAddTv = findViewById(R.id.btnAddTv)
        llContainer = findViewById(R.id.llContainer)
        btnConfirm = findViewById(R.id.btnConfirm)
        spLanguage = findViewById(R.id.spLanguage)
        tvResult = findViewById(R.id.tvResult)

        // 区域1：动态新增TextView
        btnAddTv.setOnClickListener {
            count++
            val newTv = TextView(this)
            val textStr = getString(R.string.new_tv_prefix) + count
            newTv.text = textStr
            newTv.textSize = 24f
            llContainer.addView(newTv)
        }

        // 区域2：MVC确定按钮
        btnConfirm.setOnClickListener {
            val selectedLang = spLanguage.selectedItem.toString()
            val strResId = model.getLanguageInfo(selectedLang)
            tvResult.text = getString(strResId)
        }
    }
}
