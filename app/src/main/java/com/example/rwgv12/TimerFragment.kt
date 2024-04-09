package com.example.rwgv12

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.scheduleAtFixedRate

class TimerFragment : Fragment() {
    private val timer = Timer()
    private var count = 0
    private var isRunning = false
    private var task: TimerTask? = null
    private var isDurationSelected = false


    private lateinit var timerTextView: TextView
    private lateinit var startStopButton: Button
    private lateinit var resetButton: Button
    private lateinit var restWorkTextView: TextView
    private var selectedDuration = 0
    private lateinit var selectDurationTextView: TextView
    private lateinit var readyTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_timer2, container, false)
        timerTextView = view.findViewById(R.id.selectDurationTextView)
        startStopButton = view.findViewById(R.id.startStopButton)
        resetButton = view.findViewById(R.id.resetButton)
        restWorkTextView = view.findViewById(R.id.restWorkTextView) // Initialize restWorkTextView
        startStopButton.isEnabled = false
        selectedDuration = 0
        isDurationSelected = false
        selectDurationTextView = view.findViewById(R.id.selectDurationTextView)
        readyTextView = view.findViewById(R.id.readyTextView)

        // Set click listeners for the duration buttons
        view.findViewById<Button>(R.id.buttonTwenty).setOnClickListener {
            selectedDuration = 20 // Set selected duration to 20 seconds
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            startStopButton.isEnabled = true // Enable the startStopButton
            isDurationSelected = true // Update isDurationSelected flag
            it.setBackgroundColor(resources.getColor(R.color.light_grey))
            // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonThirty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonThirty).setOnClickListener {
            selectedDuration = 30 // Set selected duration to 30 seconds
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            startStopButton.isEnabled = true // Enable the startStopButton
            isDurationSelected = true // Update isDurationSelected flag
            it.setBackgroundColor(resources.getColor(R.color.light_grey))
            // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonTwenty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonFortyFive).setOnClickListener {
            selectedDuration = 45 // Set selected duration to 45 seconds
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            startStopButton.isEnabled = true // Enable the startStopButton
            isDurationSelected = true // Update isDurationSelected flag
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
            // Update UI when timer starts
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            // Set the initial text of readyTextView to the count
            readyTextView.text = count.toString()
            task = timer.scheduleAtFixedRate(0, 1000) {
                count++
                if (count >= 60) {
                    count = 0 // Reset the count if it reaches the selected duration
                }
                activity?.runOnUiThread {
                    updateTimerText()
                    // Update the text of readyTextView with the count
                    readyTextView.text = count.toString()
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
        timerTextView.text = "0"  // Update timerTextView to display reset count
        restWorkTextView.text = ""  // Reset restWorkTextView to initial state
        readyTextView.text = "Ready"  // Reset readyTextView text
        timerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)  // Reset readyTextView text size
        readyTextView.visibility = View.GONE  // Hide readyTextView
        selectDurationTextView.visibility = View.VISIBLE  // Show selectDurationTextView
    }


    private fun updateTimerText() {
        val timerText = "$count"
        timerTextView.text = timerText

        // Determine the work/rest status based on the selected duration
        val restWorkText = if (count < selectedDuration) {
            "Work!"
        } else {
            "Rest..."
        }
        restWorkTextView.text = restWorkText
    }
}