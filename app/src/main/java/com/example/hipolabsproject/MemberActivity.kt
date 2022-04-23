package com.example.hipolabsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        val buttonClick = findViewById<Button>(R.id.save)
        buttonClick.setOnClickListener {
            finish();
        }
        """        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)"""

    }
}