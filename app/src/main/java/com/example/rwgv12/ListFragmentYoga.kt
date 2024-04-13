package com.example.rwgv12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragmentYoga : Fragment() {
    private val yogaExerciseList = mutableListOf(
        "Mountain Pose (Tadasana)", "Downward-Facing Dog (Adho Mukha Svanasana)", "Warrior I (Virabhadrasana I)", "Warrior II (Virabhadrasana II)", "Warrior III (Virabhadrasana III)", "Tree Pose (Vrksasana)", "Chair Pose (Utkatasana)", "Cobra Pose (Bhujangasana)", "Child's Pose (Balasana)", "Cat-Cow Stretch (Marjaryasana-Bitilasana)", "Bridge Pose (Setu Bandhasana)", "Plank Pose (Phalakasana)", "Boat Pose (Navasana)", "Seated Forward Bend (Paschimottanasana)", "Corpse Pose (Savasana)", "Seated Twist (Ardha Matsyendrasana)", "Camel Pose (Ustrasana)", "Pigeon Pose (Eka Pada Rajakapotasana)", "Fish Pose (Matsyasana)", "Locust Pose (Salabhasana)", "Half Moon Pose (Ardha Chandrasana)", "Extended Triangle Pose (Utthita Trikonasana)", "Extended Side Angle Pose (Utthita Parsvakonasana)", "Upward-Facing Dog (Urdhva Mukha Svanasana)", "Standing Forward Bend (Uttanasana)", "Revolved Triangle Pose (Parivrtta Trikonasana)", "Revolved Side Angle Pose (Parivrtta Parsvakonasana)", "Crow Pose (Bakasana)", "Garland Pose (Malasana)", "Happy Baby Pose (Ananda Balasana)", "Shoulder Stand (Sarvangasana)", "Headstand (Sirsasana)", "Handstand (Adho Mukha Vrksasana)", "Four-Limbed Staff Pose (Chaturanga Dandasana)", "Bound Angle Pose (Baddha Konasana)", "Reclining Bound Angle Pose (Supta Baddha Konasana)", "Revolved Chair Pose (Parivrtta Utkatasana)", "Revolved Half Moon Pose (Parivrtta Ardha Chandrasana)", "Dolphin Pose (Ardha Pincha Mayurasana)", "Cow Face Pose (Gomukhasana)", "Garland Pose (Malasana)", "Lotus Pose (Padmasana)", "Firefly Pose (Tittibhasana)", "Scale Pose (Tolasana)", "Wide-Legged Forward Bend (Prasarita Padottanasana)", "Revolved Head-to-Knee Pose (Parivrtta Janu Sirsasana)", "Intense Side Stretch Pose (Parsvottanasana)", "Noose Pose (Pasasana)", "King Pigeon Pose (Rajakapotasana)", "Sage Pose (Marichyasana)"
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
        yogaExerciseList.shuffle()

        // Find the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.exerciseRecyclerView)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Create and set up the adapter
        val adapter = ExerciseAdapter(yogaExerciseList)
        recyclerView.adapter = adapter

        // Find the refresh button
        val refreshButton: Button = view.findViewById(R.id.refreshButton)

        // Set click listener for the refresh button
        refreshButton.setOnClickListener {
            // Shuffle the exercise list again
            yogaExerciseList.shuffle()

            // Notify the adapter that the dataset has changed
            adapter.notifyDataSetChanged()
        }
    }
}
