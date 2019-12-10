package edu.utng.mx.introducciondesarrolloenandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.utng.mx.introducciondesarrolloenandroid.R
import edu.utng.mx.introducciondesarrolloenandroid.video1Activity
import kotlinx.android.synthetic.main.activity_informacion1.*

class informacion1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion1)
        btnVer.setOnClickListener {
            startActivity(Intent(this, video1Activity::class.java))
        }
    }
}
