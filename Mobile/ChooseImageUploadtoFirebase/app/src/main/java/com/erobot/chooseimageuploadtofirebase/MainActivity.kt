package com.erobot.chooseimageuploadtofirebase

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var filepath : Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{
            startFileChooser()
        }
        button2.setOnClickListener{
            uploadFile()
        }
    }

    private fun uploadFile() {
        if(filepath != null){
            val pd = ProgressDialog(this)
            pd.setTitle("Uploading")
            pd.show()
            var imageRef = FirebaseStorage.getInstance().reference.child("image/pic.jpg")
            imageRef.putFile(filepath)
                    .addOnSuccessListener { p0 ->
                        pd.dismiss()
                        Toast.makeText(applicationContext, "File is uploaded", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { p0 ->
                        pd.dismiss()
                        Toast.makeText(applicationContext, p0.message, Toast.LENGTH_SHORT).show()
                    }
                    .addOnProgressListener { p0 ->
                        var progress = (100.0 * p0.bytesTransferred)/p0.totalByteCount
                        pd.setMessage("Uploaded ${progress.toInt()}%")
                    }
        }
    }

    private fun startFileChooser(){
        var i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i, "Choose Picture"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 111 && resultCode == Activity.RESULT_OK && data != null){
            filepath = data.data!!
            var bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            imageView.setImageBitmap(bitmap)
        }
    }
}