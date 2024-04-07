package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.scheduleAtFixedRate

class TimerFragment : Fragment() {
    private val timer = Timer()
    private var count = 0
    private var isRunning = false
    private var task: TimerTask? = null

    private lateinit var timerTextView: TextView
    private lateinit var startStopButton: Button
    private lateinit var resetButton: Button
    private lateinit var restWorkTextView: TextView


    private var selectedDuration = 0 // Variable to store the selected duration in seconds

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_timer2, container, false)
        timerTextView = view.findViewById(R.id.textView)
        startStopButton = view.findViewById(R.id.startStopButton)
        resetButton = view.findViewById(R.id.resetButton)
        restWorkTextView = view.findViewById(R.id.restWorkTextView) // Initialize restWorkTextView
        startStopButton.isEnabled = false

        // Set click listeners for the duration buttons
        view.findViewById<Button>(R.id.buttonTwenty).setOnClickListener {
            selectedDuration = 20 // Set selected duration to 20 seconds
            startStopButton.isEnabled = true // Enable the startStopButton
            it.setBackgroundColor(resources.getColor(R.color.light_grey))
            // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonThirty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonThirty).setOnClickListener {
            selectedDuration = 30 // Set selected duration to 30 seconds
            startStopButton.isEnabled = true // Enable the startStopButton
            it.setBackgroundColor(resources.getColor(R.color.light_grey))
            // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonTwenty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonFortyFive).setOnClickListener {
            selectedDuration = 45 // Set selected duration to 45 seconds
            startStopButton.isEnabled = true // Enable the startStopButton
            it.setBackgroundColor(resources.getColor(R.color.light_grey))
            // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonTwenty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonThirty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startStopButton.setOnClickListener {
            if (isRunning) {
                stopTimer()
            } else {
                startTimer()
            }
        }

        resetButton.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        if (!isRunning) {
            isRunning = true
            task = timer.scheduleAtFixedRate(0, 1000) {
                count++
                if (count >= 60) {
                    count = 0 // Reset the count if it reaches the selected duration
                }
                activity?.runOnUiThread {
                    updateTimerText()
                }
            }
        }
    }

    private fun stopTimer() {
        task?.cancel()
        isRunning = false
    }

    private fun resetTimer() {
        stopTimer()
        count = 0
        updateTimerText()
    }

    private fun updateTimerText() {
        val timerText = "$count"
        timerTextView.text = timerText

        // Determine the work/rest status based on the selected duration
        val restWorkText = if (count < selectedDuration) {
            "Work"
        } else {
            "Rest"
        }
        restWorkTextView.text = restWorkText
    }
}