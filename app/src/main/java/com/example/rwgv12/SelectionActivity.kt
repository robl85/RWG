package com.example.rwgv12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.rwgv12.ui.theme.RWGV12Theme

class SelectionActivity : ComponentActivity() {
    private lateinit var allExercisesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        allExercisesButton = findViewById(R.id.allExercisesButton)

        allExercisesButton.setOnClickListener {
            val selectionActivity = Intent(this, MainActivity::class.java)
            startActivity(selectionActivity)
        }
    }
}
