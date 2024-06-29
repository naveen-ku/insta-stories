package com.example.instastories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instastories.data.db.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}