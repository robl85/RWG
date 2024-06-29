package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentCoreNo : Fragment() {
    private val coreNoExerciseList = mutableListOf(
        "Plank", "Side Plank", "Bicycle Crunches", "Russian Twists", "Mountain Climbers", "Flutter Kicks", "Leg Raises", "Sit-ups", "Crunches", "Reverse Crunches", "Superman", "Dead Bug", "Hollow Hold", "V-Ups", "Scissor Kicks", "Plank Jacks", "Spiderman Plank", "Commando Plank", "Side Plank with Hip Dip", "Plank with Shoulder Taps", "Plank with Knee to Elbow", "Boat Pose", "Knee Tucks", "Russian Twists with Leg Raises", "Tuck-ups", "Bicycle Crunches with Leg Extension", "Plank with Leg Lifts", "Plank with Arm Raises", "Plank with Alternating Leg and Arm Lifts", "Lying Windshield Wipers", "Lying Leg Lifts", "Standing Oblique Crunches", "Lying Knee Tucks", "Lying Leg Raises with Hip Lift", "Lying Leg Circles", "Standing Knee to Elbow Crunches", "Standing Oblique Crunches with Leg Lift", "Standing Leg Swings", "Standing Mountain Climbers", "Standing Knee Raises with Twist", "Standing Side Leg Raises", "Standing Side-to-Side Bends", "Standing Alternating Toe Touches"
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
        coreNoExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(coreNoExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            coreNoExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
