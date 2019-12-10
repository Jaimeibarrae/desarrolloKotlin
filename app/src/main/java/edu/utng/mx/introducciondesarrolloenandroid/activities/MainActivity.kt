package edu.utng.mx.introducciondesarrolloenandroid.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.utng.mx.introducciondesarrolloenandroid.R
import edu.utng.mx.introducciondesarrolloenandroid.informacion4Activity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title="Tutorial Kotlin"
        button.setOnClickListener {
            startActivity(Intent(this,informacion1Activity::class.java))
        }
        button2.setOnClickListener{
            startActivity(Intent(this,informacion2Activity::class.java))
        }

        button3.setOnClickListener{
            startActivity(Intent(this,informacion3Activity::class.java))
        }

        button4.setOnClickListener{
            startActivity(Intent(this, informacion4Activity::class.java))
        }
        regresar.setOnClickListener{
           this.finish()
        }

    }


}
