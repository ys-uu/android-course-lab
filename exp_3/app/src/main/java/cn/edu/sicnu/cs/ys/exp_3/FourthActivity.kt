package cn.edu.sicnu.cs.ys.exp_3

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class FourthActivity : AppCompatActivity() {
    private lateinit var ivPhoto: ImageView

    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            val bitmap:Bitmap? = result.data?.extras?.get("data") as Bitmap?
            ivPhoto.setImageBitmap(bitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        ivPhoto = findViewById(R.id.iv_show_photo)
        val btnPhoto:Button = findViewById(R.id.btn_photo)

        btnPhoto.setOnClickListener {
            // 隐式Intent调用系统相机
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(intent)
        }
    }
}
