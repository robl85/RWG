package com.example.rwgv12

import android.os.Bundle
import android.util.TypedValue
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
    private var reps = 0
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
        resetButton.isEnabled = false
        selectedDuration = 0
        isDurationSelected = false
        selectDurationTextView = view.findViewById(R.id.selectDurationTextView)
        readyTextView = view.findViewById(R.id.readyTextView)

        // Set click listeners for the duration buttons
        view.findViewById<Button>(R.id.buttonTwenty).setOnClickListener {
            selectedDuration = 20
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            startStopButton.isEnabled = true
            resetButton.isEnabled = false
            isDurationSelected = true
            it.setBackgroundColor(resources.getColor(R.color.light_grey)) // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonThirty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonThirty).setOnClickListener {
            selectedDuration = 30
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            startStopButton.isEnabled = true
            resetButton.isEnabled = false
            isDurationSelected = true
            it.setBackgroundColor(resources.getColor(R.color.light_grey)) // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonTwenty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonFortyFive).setOnClickListener {
            selectedDuration = 45
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.VISIBLE
            startStopButton.isEnabled = true
            resetButton.isEnabled = false
            isDurationSelected = true
            it.setBackgroundColor(resources.getColor(R.color.light_grey)) // Reset background color of other buttons
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
            selectDurationTextView.visibility = View.GONE
            readyTextView.visibility = View.GONE
            timerTextView.textSize = 40f
            timerTextView.visibility = View.VISIBLE
            restWorkTextView.visibility = View.VISIBLE
            resetButton.isEnabled = true
            // Start the timer task
            task = timer.scheduleAtFixedRate(0, 1000) {
                activity?.runOnUiThread {
                    count++
                    updateTimerText()
                    if (count >= 60) {
                        count = 0
                        reps++
                    }
                    updateReadyTextView()
                }
            }
        }
    }

    private fun updateReadyTextView() {
        readyTextView.text = "Ready"
        readyTextView.textSize = 40f
        timerTextView.text = "Time: $count | Reps: $reps"
    }

    private fun stopTimer() {
        task?.cancel()
        isRunning = false
    }

    private fun resetTimer() {
        stopTimer()
        count = 0
        reps = 0
        readyTextView.visibility = View.GONE
        readyTextView.text = "Ready"
        readyTextView.textSize = 40f
        timerTextView.text = "Time: 0 | Reps: 0"
        timerTextView.visibility = View.GONE
        restWorkTextView.visibility = View.GONE
        selectDurationTextView.visibility = View.VISIBLE
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