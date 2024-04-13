package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentLowImpact : Fragment() {
    private val lowImpactExerciseList = mutableListOf(
        "March in Place", "Wall Sit", "Bodyweight Squats", "Stationary Lunges", "Calf Raises", "Glute Bridges", "Clamshells", "Side Leg Raises", "Donkey Kicks", "Fire Hydrants", "Standing Leg Swings", "Arm Circles", "Knee Lifts", "Side-to-Side Leg Swings", "Hip Circles", "Leg Circles", "Arm Raises (front, side, and back)", "Chair Squats", "Seated Leg Extensions", "Seated Leg Presses", "Seated Marches", "Seated Knee Lifts", "Seated Leg Raises", "Seated Arm Circles", "Seated Torso Twists", "Seated Tricep Dips", "Wall Push-ups", "Incline Push-ups (using a sturdy surface like a countertop)", "Plank", "Modified Plank (on knees)", "Side Plank", "Bird Dogs"
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
        lowImpactExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(lowImpactExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            lowImpactExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
