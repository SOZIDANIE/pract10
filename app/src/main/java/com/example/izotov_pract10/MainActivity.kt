package com.example.izotov_pract10

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toast1 = Toast.makeText(applicationContext, "Введите пароль", Toast.LENGTH_SHORT)
        val intent = Intent(this, info_ekran :: class.java)
        val Button = findViewById<Button>(R.id.button)
        val Button1 = findViewById<Button>(R.id.button2)
        val editText = findViewById<EditText>(R.id.editTextTextPassword)
        val preferences = getSharedPreferences("str", MODE_PRIVATE)
        if (preferences.contains("str")){
            Button.visibility = View.INVISIBLE
            Button1.visibility = View.VISIBLE
        }
        Button.setOnClickListener {
            val x = editText.text.toString()
            Log.d("Preferences", preferences.getString("str", x).toString())
            val toast = Toast.makeText(applicationContext, "Пароль задан", Toast.LENGTH_SHORT)
            val edit = preferences.edit()
            edit.putString("str", editText.text.toString())
            edit.apply()
            toast.show()
        }
        Button1.setOnClickListener {
            val c = preferences.getString("str", "is empty").toString()
            val v = editText.text.toString()
           if (c == v){
                val edit = preferences.edit()
                edit.clear()
                edit.apply()
                startActivity(intent)
            }
            else{
                toast1.show()
            }
        }
    }
}

