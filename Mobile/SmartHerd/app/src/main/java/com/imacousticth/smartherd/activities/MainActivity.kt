package com.imacousticth.smartherd.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.imacousticth.smartherd.Constants
import com.imacousticth.smartherd.R
import com.imacousticth.smartherd.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            Log.i(TAG, "Button was clicked")  //i stand for information    //TAG also can use MainActivity.TAG
            showToast(resources.getString(R.string.btn_was_click), Toast.LENGTH_LONG)
        }

        btnSendMessageToNextActivity.setOnClickListener{
            var message: String = etUserMessage.text.toString()  // == getText in java
            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            //we use explicit intent
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }

        BtnShareToOtherApp.setOnClickListener{

            var message: String = etUserMessage.text.toString()  // == getText in java

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)

            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, resources.getString(R.string.share_to)))
        }

        btnRecyclerViewDemo.setOnClickListener{
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}