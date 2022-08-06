package droid.maxaria.maxander.movietest.presenter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.movietest.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var onBackPressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (onBackPressed + 2000 > System.currentTimeMillis()) {
            finish()
        } else {
            Toast.makeText(baseContext, R.string.click_again, Toast.LENGTH_LONG).show()
        }
        onBackPressed = System.currentTimeMillis()
    }
}