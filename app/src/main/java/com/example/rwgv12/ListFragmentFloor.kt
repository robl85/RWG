package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentFloor : Fragment() {
    private val floorExerciseList = mutableListOf(
        "Seated Leg Raises", "Seated Leg Extensions", "Seated Torso Twists", "Seated Tricep Dips", "Seated Bicep Curls", "Seated Shoulder Raises", "Seated Chest Presses", "Seated Rows", "Wall Sit", "Chair Squats", "Chair Leg Raises", "Chair Side Leg Raises", "Chair Toe Taps", "Chair Crunches", "Chair Leg Circles", "Chair Hip Circles", "Chair Shoulder Rolls", "Chair Arm Raises (front, side, and back)", "Lying Leg Raises", "Lying Glute Bridges", "Lying Hip Abductions", "Lying Knee Tucks", "Lying Hamstring Curls", "Lying Side Leg Raises", "Lying Clamshells", "Lying Arm Raises (front, side, and back)", "Lying Bicep Curls", "Lying Tricep Extensions", "Lying Shoulder Presses", "Lying Chest Flyes", "Lying Rows", "Lying Superman", "Lying Spinal Twist"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Shuffle the exercise list
        floorExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(floorExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            floorExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
