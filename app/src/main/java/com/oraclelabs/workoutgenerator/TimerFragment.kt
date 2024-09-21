package com.oraclelabs.workoutgenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.rwgv12.R
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_timer, container, false)
        timerTextView = view.findViewById(R.id.selectDurationTextView)
        startStopButton = view.findViewById(R.id.startStopButton)
        resetButton = view.findViewById(R.id.resetButton)
        restWorkTextView = view.findViewById(R.id.restWorkTextView) // Initialize restWorkTextView
        startStopButton.isEnabled = false
        resetButton.isEnabled = false
        selectedDuration = 0
        isDurationSelected = false
        selectDurationTextView = view.findViewById(R.id.selectDurationTextView)

        // Set click listeners for the duration buttons
        view.findViewById<Button>(R.id.buttonTwenty).setOnClickListener {
            selectedDuration = 20
            selectDurationTextView.visibility = View.GONE
            timerTextView.visibility = View.VISIBLE
            timerTextView.text = "Time: $count | Reps: $reps"
            startStopButton.isEnabled = true
            resetButton.isEnabled = false
            isDurationSelected = true
            it.setBackgroundColor(resources.getColor(R.color.black)) // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonThirty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonThirty).setOnClickListener {
            selectedDuration = 30
            selectDurationTextView.visibility = View.GONE
            timerTextView.visibility = View.VISIBLE
            timerTextView.text = "Time: $count | Reps: $reps"
            startStopButton.isEnabled = true
            resetButton.isEnabled = false
            isDurationSelected = true
            it.setBackgroundColor(resources.getColor(R.color.black))
// Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonTwenty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonFortyFive)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        view.findViewById<Button>(R.id.buttonFortyFive).setOnClickListener {
            selectedDuration = 45
            selectDurationTextView.visibility = View.GONE
            timerTextView.visibility = View.VISIBLE
            timerTextView.text = "Time: $count | Reps: $reps"
            startStopButton.isEnabled = true
            resetButton.isEnabled = false
            isDurationSelected = true
            it.setBackgroundColor(resources.getColor(R.color.black)) // Reset background color of other buttons
            view.findViewById<Button>(R.id.buttonTwenty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
            view.findViewById<Button>(R.id.buttonThirty)
                .setBackgroundColor(resources.getColor(android.R.color.transparent))
        }

        // Restore state if savedInstanceState is not null
        savedInstanceState?.let { bundle ->
            count = bundle.getInt("count")
            reps = bundle.getInt("reps")
            isRunning = bundle.getBoolean("isRunning")
            selectedDuration = bundle.getInt("selectedDuration")
            isDurationSelected = bundle.getBoolean("isDurationSelected")
            if (isRunning) startTimer()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startStopButton.setOnClickListener {
            resetButton.isEnabled = true
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the current state of the timer
        outState.putInt("count", count)
        outState.putInt("reps", reps)
        outState.putBoolean("isRunning", isRunning)
        outState.putInt("selectedDuration", selectedDuration)
        outState.putBoolean("isDurationSelected", isDurationSelected)
    }

    private fun startTimer() {
        if (!isRunning) {
            isRunning = true
            selectDurationTextView.visibility = View.GONE
            timerTextView.textSize = 40f
            timerTextView.visibility = View.VISIBLE
            restWorkTextView.visibility = View.VISIBLE
            resetButton.isEnabled = true
            var repCounted = false // Flag to track whether rep has been counted for the current cycle
            // Start the timer task
            task = timer.scheduleAtFixedRate(0, 1000) {
                activity?.runOnUiThread {
                    count++
                    updateTimerText()
                    if (count >= selectedDuration && !repCounted) {
                        reps++
                        repCounted = true // Set flag to true once rep is counted
                    }
                    if (count >= 60) {
                        count = 0
                        repCounted = false // Reset flag when timer passes 60
                    }
                    updatetimerTextView()
                }
            }
        }
    }


    private fun updatetimerTextView() {
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
        timerTextView.text = "Time: 0 | Reps: 0"
        timerTextView.visibility = View.GONE
        restWorkTextView.text = ""
        selectDurationTextView.visibility = View.VISIBLE
        view?.findViewById<Button>(R.id.buttonTwenty)?.setBackgroundColor(resources.getColor(android.R.color.transparent))
        view?.findViewById<Button>(R.id.buttonThirty)?.setBackgroundColor(resources.getColor(android.R.color.transparent))
        view?.findViewById<Button>(R.id.buttonFortyFive)?.setBackgroundColor(resources.getColor(android.R.color.transparent))
        isDurationSelected = false
        startStopButton.isEnabled = false
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
    private fun handleDurationButtonClicked() {
        startStopButton.isEnabled = true
        resetButton.isEnabled = false
        isDurationSelected = true
        selectDurationTextView.visibility = View.GONE
        timerTextView.visibility = View.VISIBLE
        timerTextView.textSize = 40f
        timerTextView.text = "Time: $count | Reps: $reps"
        restWorkTextView.visibility = View.VISIBLE
    }
}