package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentUpperNo : Fragment() {
    private val upperNoExerciseList = mutableListOf(
        "Burpees", "Mountain Climbers", "Push-up Jacks", "Plank Shoulder Taps", "Commando Rows", "Plyometric Push-ups", "Bicycle Crunches", "Superman", "Jumping Jacks", "High Knees", "Spiderman Push-ups", "Plank Jacks", "Russian Twists", "Incline Push-ups", "Diamond Push-ups", "Punches (without weights)", "Shoulder Press (using bodyweight)", "Chest Press (using bodyweight)", "Bicep Curls (using resistance bands or bodyweight)", "Tricep Extensions (using bodyweight)", "Plank to Push-up", "Shoulder Circles", "Handstand Push-ups (against a wall)", "Walking Push-ups", "Shoulder Taps (standing or plank)", "Push-up Variations (e.g., clapping, staggered, one-arm)", "Side Plank Hip Dips"
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
        upperNoExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(upperNoExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            upperNoExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
