package com.oraclelabs.workoutgenerator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.oraclelabs.workoutgenerator.R;

class SelectionActivity : ComponentActivity() {
    private lateinit var allExercisesButton: Button
    private lateinit var upperNoEquipmentExercisesButton: Button
    private lateinit var upperWithEquipmentExercisesButton: Button
    private lateinit var lowerNoEquipmentExercisesButton: Button
    private lateinit var lowerWithEquipmentExercisesButton: Button
    private lateinit var coreNoEquipmentExercisesButton: Button
    private lateinit var coreWithEquipmentExercisesButton: Button
    private lateinit var yogaExerciseButton: Button
    private lateinit var lowImpactExerciseButton: Button
    private lateinit var floorExerciseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        allExercisesButton = findViewById(R.id.allExercisesButton)

        allExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentAll) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        upperNoEquipmentExercisesButton = findViewById(R.id.upperNoEquipmentExercisesButton)

        upperNoEquipmentExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentUpperNo) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        upperWithEquipmentExercisesButton = findViewById(R.id.upperWithEquipmentExercisesButton)

        upperWithEquipmentExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentUpperWith) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        lowerNoEquipmentExercisesButton = findViewById(R.id.lowerNoEquipmentExercisesButton)

        lowerNoEquipmentExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentLowerNo) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        lowerWithEquipmentExercisesButton = findViewById(R.id.lowerWithEquipmentExercisesButton)

        lowerWithEquipmentExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentLowerWith) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        coreNoEquipmentExercisesButton = findViewById(R.id.coreNoEquipmentExercisesButton)

        coreNoEquipmentExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentCoreNo) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        coreWithEquipmentExercisesButton = findViewById(R.id.coreWithEquipmentExercisesButton)

        coreWithEquipmentExercisesButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentCoreWith) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        yogaExerciseButton = findViewById(R.id.yogaExerciseButton)

        yogaExerciseButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentYoga) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        lowImpactExerciseButton = findViewById(R.id.lowImpactExerciseButton)

        lowImpactExerciseButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentLowImpact) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
        floorExerciseButton = findViewById(R.id.floorExerciseButton)

        floorExerciseButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("FRAGMENT_TO_LOAD", MainActivity.FragmentConstants.ListFragmentFloor) // Or FragmentConstants.FRAGMENT_B based on the button pressed
            }
            startActivity(intent)
        }
    }
}
