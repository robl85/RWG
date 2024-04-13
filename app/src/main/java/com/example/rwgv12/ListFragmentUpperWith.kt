package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentUpperWith : Fragment() {
    private val upperWithExerciseList = mutableListOf(
        "Dumbbell Thrusters", "Renegade Rows", "Medicine Ball Slams", "Shoulder Press", "Chest Press", "Bicep Curls", "Tricep Extensions", "Lateral Raises", "Russian Twists with weight", "Box Jumps", "Pull-ups", "Chin-ups", "Hanging Leg Raises", "Dumbbell Rows", "Upright Rows", "Medicine Ball Push-ups", "Battle Rope Waves", "Kettlebell Swings", "Rows- Resistance bands", "Pushups- Resistance bands", "Chest Press- Resistance bands", "Bicep Curls- Resistance bands", "Tricep Extensions- Resistance bands", "Pike Pushups- Resistance bands", "Y Raises- Resistance bands", "T Raises- Resistance bands", "W Raises- Resistance bands", "Atomic Pushups- Resistance bands", "Inverted Rows- Resistance bands", "Inverted Bicep Curls- Resistance bands", "Inverted Tricep Extensions- Resistance bands", "Side Plank with Rotation- Resistance bands", "Singlearm Rows- Resistance bands", "Singlearm Bicep Curls- Resistance bands", "Singlearm Tricep Extensions- Resistance bands", "Suspended Pushups- Resistance bands", "Suspended Pike- Resistance bands", "Suspended Crunches- Resistance bands", "Suspended Russian Twists- Resistance bands", "Suspended Lateral Lunges- Resistance bands", "Suspended Mountain Climbers- Resistance bands", "Suspended Knee Tucks- Resistance bands", "Suspended Pendulum Swings- Resistance bands", "Suspended Plank- Resistance bands", "Suspended Side Plank- Resistance bands", "Suspended Hip Press- Resistance bands", "Suspended Lunge- Resistance bands", "Suspended Atomic Pushups- Resistance bands", "Suspended Burpees- Resistance bands", "Suspended High Knees- Resistance bands"
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
        upperWithExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(upperWithExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            upperWithExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
