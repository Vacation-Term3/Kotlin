package com.erobot.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTitle: String
    private lateinit var editTextDescription: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTitle = (findViewById<EditText>(R.id.edit_text_title)).toString()
        editTextDescription = (findViewById<EditText>(R.id.edit_text_description)).toString()

        Toast.makeText(this, editTextTitle, Toast.LENGTH_SHORT).show()

    }

    companion object {
        private const val KEY_TITLE:String = "title"
        private const val TAG = "MainActivity"
        private const val KEY_DESCRIPTION:String = "description"
    }
}