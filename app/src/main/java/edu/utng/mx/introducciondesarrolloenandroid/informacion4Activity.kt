package edu.utng.mx.introducciondesarrolloenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_informacion1.*

class informacion4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion4)
        btnVer.setOnClickListener {
            startActivity(Intent(this, video4Activity::class.java))
        }
    }
}
