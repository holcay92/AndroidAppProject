package com.example.hipolabsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MemberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)
        val buttonClick = findViewById<Button>(R.id.save)
        buttonClick.setOnClickListener {

            val company = "Hipo"
            val team = "Android"
            val name1: EditText = findViewById(R.id.name_entry_title);
            val name : String = name1.text.toString();
            val age1: EditText = findViewById(R.id.age_entry_title);
            val age : Int = age1.text.toString().toInt();
            val loc1: EditText = findViewById(R.id.location_entry_title);
            val location : String = loc1.text.toString();
            val git: EditText = findViewById(R.id.github_entry_title);
            val github : String = git.text.toString();
            val pos: EditText = findViewById(R.id.position_entry_title);
            val position : String = pos.text.toString();
            val yearsinhipo: EditText = findViewById(R.id.years_in_hipo_entry_title);
            val years_in_hipo : Int = yearsinhipo.text.toString().toInt();

            memberList.add(Member(company,team,name, age, location, github, position, years_in_hipo))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}