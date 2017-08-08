package me.baleen.sharedpreferencedelegate

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PreferenceUtil.init(applicationContext)

        val userPref = UserPreference()
        emailText.text = "userPref.email ${userPref.email}"

        emailText.setOnClickListener {
            userPref.email = "baleen37@gmail.com"
            emailText.text = "userPref.email ${userPref.email}"
        }
    }
}
