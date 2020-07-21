package com.erobot.getsetdatafirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var database = FirebaseDatabase.getInstance().reference
        //database.setValue("SOTHEA")

        button.setOnClickListener{
            var empNo = InputNO.text.toString().toInt()
            var empName = InputPersonName.text.toString()
            var empSal = InputSalary.text.toString().toInt()

            database.child(empNo.toString()).setValue(Employee(empName, empSal))
        }

        //Get Data
        var getData = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder()
                for(i in snapshot.children){
                    var empName = i.child("empName").getValue()
                    var empSal = i.child("empSal").getValue()
                    sb.append("${i.key} $empName $empSal\n")
                }
                textView.setText(sb)
            }

        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }
}