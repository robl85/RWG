package com.oraclelabs.workoutgenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rwgv12.R


class ListFragmentAll : Fragment() {
    private val allExerciseList = mutableListOf(
        "Burpees", "Mountain Climbers", "Push-up Jacks", "Plank Shoulder Taps", "Commando Rows", "Plyometric Push-ups", "Bicycle Crunches", "Superman", "Jumping Jacks", "High Knees", "Spiderman Push-ups", "Plank Jacks", "Russian Twists", "Incline Push-ups", "Diamond Push-ups", "Punches (without weights)", "Shoulder Press (using bodyweight)", "Chest Press (using bodyweight)", "Bicep Curls (using resistance bands or bodyweight)", "Tricep Extensions (using bodyweight)", "Plank to Push-up", "Shoulder Circles", "Handstand Push-ups (against a wall)", "Walking Push-ups", "Shoulder Taps (standing or plank)", "Push-up Variations (e.g., clapping, staggered, one-arm)", "Side Plank Hip Dips", "Bodyweight Squats", "Lunges (Reverse)", "Jump Squats", "Jump Lunges", "Bulgarian Split Squats", "Curtsy Lunges", "Single-Leg Squats (Pistol Squats)", "Calf Raises", "Glute Bridges", "Single-Leg Glute Bridges", "Donkey Kicks", "Fire Hydrants", "Wall Sits", "Side Lunges", "Plie Squats", "Skater Jumps", "High Knees", "Butt Kicks", "Standing Leg Lifts", "Sumo Squats", "Frog Jumps", "Bear Crawls", "Crab Walks", "Mountain Climbers", "Standing Calf Raises", "Side Plank Leg Lifts", "Wall Sit with Leg Lifts", "Jumping Jacks", "Side-to-Side Squat Jumps", "Squat Pulses", "Reverse Lunges with Knee Drive", "Skater Squats", "Duck Walks", "Standing Hip Circles", "Forward and Backward Leg Swings", "Side Leg Swings", "Lateral Leg Raises", "Standing Knee to Elbow", "Standing Donkey Kicks", "Standing Fire Hydrants", "Standing Knee Circles", "Lunges (Forward)", "Plank", "Side Plank", "Bicycle Crunches", "Russian Twists", "Mountain Climbers", "Flutter Kicks", "Leg Raises", "Sit-ups", "Crunches", "Reverse Crunches", "Superman", "Bird Dogs", "Dead Bug", "Hollow Hold", "V-Ups", "Scissor Kicks", "Plank Jacks", "Spiderman Plank", "Commando Plank", "Side Plank with Hip Dip", "Plank with Shoulder Taps", "Plank with Knee to Elbow", "Boat pose", "Knee Tucks"
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
        allExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(allExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            allExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
