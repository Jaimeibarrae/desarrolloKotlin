package edu.utng.mx.introducciondesarrolloenandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.utng.mx.introducciondesarrolloenandroid.R
import edu.utng.mx.introducciondesarrolloenandroid.video1Activity
import edu.utng.mx.introducciondesarrolloenandroid.video2Activity
import kotlinx.android.synthetic.main.activity_informacion1.*

class informacion2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion2)
        btnVer.setOnClickListener {
            startActivity(Intent(this, video2Activity::class.java))
        }
    }
}
