package com.oraclelabs.workoutgenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oraclelabs.workoutgenerator.R;


class ListFragmentLowerWith : Fragment() {
    private val lowerWithExerciseList = mutableListOf(
        "Goblet Squats (using a dumbbell or kettlebell)", "Weighted Lunges", "Box Jumps", "Weighted Step-ups", "Romanian Deadlifts", "Kettlebell Swings", "Dumbbell Deadlifts", "Jump Squats with Medicine Ball", "Kettlebell Lunges", "Bulgarian Split Squats with Dumbbells", "Weighted Hip Thrusts", "Cable Kickbacks", "Cable Pull-throughs", "Cable Squats", "Cable Deadlifts", "Leg Press Machine", "Leg Extension Machine", "Leg Curl Machine", "Machine Squats", "Machine Lunges", "Machine Romanian Deadlifts", "Sled Pushes", "Sled Pulls", "Resistance Band Squats", "Resistance Band Lunges", "Resistance Band Deadlifts", "Resistance Band Hip Abductions", "Resistance Band Glute Bridges", "Plyo Box Step-ups with Dumbbells", "Dumbbell Thrusters", "Resistance Band Jump Squats", "Resistance Band Bulgarian Split Squats", "Resistance Band Pistol Squats", "Resistance Band Hamstring Curls", "Resistance Band Hip Thrusts", "Resistance Band Lateral Lunges", "Resistance Band Squat Jumps", "Resistance Band Box Jumps", "Resistance Band Side Lunges", "Resistance Band Jump Lunges", "Resistance Band Calf Raises", "Resistance Band Sled Pushes", "Resistance Band Sled Pulls"
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
        lowerWithExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(lowerWithExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            lowerWithExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
