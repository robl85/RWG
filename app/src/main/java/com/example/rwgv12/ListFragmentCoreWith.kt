package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentCoreWith : Fragment() {
    private val coreWithExerciseList = mutableListOf(
        "Cable Crunches", "Weighted Russian Twists (using a dumbbell, medicine ball, or plate)", "Weighted Plank (using a weight plate or sandbag on your back)", "Hanging Leg Raises (using a pull-up bar)", "Ab Wheel Rollouts", "Cable Woodchoppers", "Decline Sit-ups (using a decline bench)", "Cable Twists", "Stir the Pot (using a stability ball)", "Stability Ball Rollouts", "Stability Ball Pike", "Stability Ball Pass", "Stability Ball Russian Twists", "Stability Ball Jackknife", "Stability Ball Stir the Pot", "Stability Ball Plank", "Stability Ball Knee Tucks", "Resistance Band Anti-Rotation Presses", "Resistance Band Pallof Presses", "Medicine Ball Slams", "Medicine Ball Russian Twists", "Medicine Ball V-Ups", "Medicine Ball Rotational Throws", "Medicine Ball Sit-ups", "Medicine Ball Lateral Throws", "Medicine Ball Woodchoppers", "Medicine Ball Plank Pass", "Medicine Ball Knee Tucks", "Kettlebell Windmills", "Kettlebell Turkish Get-ups", "Kettlebell Side Bends", "Kettlebell Swings", "Kettlebell Russian Twists", "Kettlebell Plank Drags", "Kettlebell Figure 8s", "Kettlebell Halo", "Kettlebell Sit-ups", "Kettlebell Dead Bug", "Kettlebell Farmers Walk"
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
        coreWithExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(coreWithExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            coreWithExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
