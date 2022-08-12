package com.example.themeandstyles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TransitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        findViewById<Button>(R.id.button).setOnClickListener { onBackPressed() }
    }
}