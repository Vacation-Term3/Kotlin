package com.imacousticth.smartherd.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.imacousticth.smartherd.Constants
import com.imacousticth.smartherd.R
import com.imacousticth.smartherd.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe Call: ?
        // Safe Call with let:  ?let
        val bundle: Bundle? = intent.extras // == getIntent & getExtras in java

        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            if (msg != null) showToast(msg)
            txvUserMessage.text = msg
        }
    }
}
