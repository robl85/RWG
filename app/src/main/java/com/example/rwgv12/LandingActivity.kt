package com.example.rwgv12

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {

    // Delay in milliseconds
    private val DELAY_MS: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        // Using Handler to post a delayed action to start SelectionActivity
        Handler().postDelayed({
            // Start SelectionActivity
            val intent = Intent(this@LandingActivity, SelectionActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish() // Finish the current activity to prevent users from navigating back to it
        }, DELAY_MS)
    }
}
