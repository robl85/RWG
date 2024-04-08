package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {
    private val exerciseList = mutableListOf(
        "Push-ups", "Crunches", "Squats", "Plank", "Burpees", "Squats",
        "Lunges", "Reverse lunges", "Sidestep lunges", "Squat shuffle", "Jumping lunges",
        "Squat jumps", "Push ups", "Narrow push ups", "Dips", "Crunches",
        "Crunches legs up touch behind legs", "Bicycle crunches", "High plank", "Side plank",
        "High plank shoulder tap", "High plank bear crawl", "Running on the spot",
        "Running punches", "Mountain climbers", "Crawl out to climbers", "Ladder climb",
        "Mountain climb to side plank", "Star jumps", "Lateral skiiers", "Box jumps",
        "High knees", "Butt kicks", "Leg raises", "Crunches feet up", "Side crunch heel touches",
        "Hip thrusts", "Seated twists", "Double squat thrusts", "Squat hold", "Pop squat",
        "Low sprint", "Knee drives", "Spiderman lunges"
    )

    private var currentIndex = 0

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
        exerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(exerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            exerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
