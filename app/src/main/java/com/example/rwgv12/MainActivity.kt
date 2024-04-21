package com.example.rwgv12

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    object FragmentConstants {
        const val ListFragmentAll = 1
        const val ListFragmentUpperNo = 2
        const val ListFragmentUpperWith = 3
        const val ListFragmentLowerNo = 4
        const val ListFragmentLowerWith = 5
        const val ListFragmentCoreNo = 6
        const val ListFragmentCoreWith = 7
        const val ListFragmentYoga = 8
        const val ListFragmentLowImpact = 9
        const val ListFragmentFloor = 10

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (intent.getIntExtra("FRAGMENT_TO_LOAD", FragmentConstants.ListFragmentAll)) {
            FragmentConstants.ListFragmentAll -> loadFragmentA()
            FragmentConstants.ListFragmentUpperNo -> loadFragmentB()
            FragmentConstants.ListFragmentUpperWith -> loadFragmentC()
            FragmentConstants.ListFragmentLowerNo -> loadFragmentD()
            FragmentConstants.ListFragmentLowerWith -> loadFragmentE()
            FragmentConstants.ListFragmentCoreNo -> loadFragmentF()
            FragmentConstants.ListFragmentCoreWith -> loadFragmentG()
            FragmentConstants.ListFragmentYoga -> loadFragmentH()
            FragmentConstants.ListFragmentLowImpact -> loadFragmentI()
            FragmentConstants.ListFragmentFloor -> loadFragmentJ()

        }
    }

    private fun loadFragmentA() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentAll())
            .commit()
    }

    private fun loadFragmentB() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentUpperNo())
            .commit()
    }
    private fun loadFragmentC() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentUpperWith())
            .commit()
    }
    private fun loadFragmentD() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentLowerNo())
            .commit()
    }
    private fun loadFragmentE() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentLowerWith())
            .commit()
    }
    private fun loadFragmentF() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentCoreNo())
            .commit()
    }
    private fun loadFragmentG() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentCoreWith())
            .commit()
    }
    private fun loadFragmentH() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentYoga())
            .commit()
    }
    private fun loadFragmentI() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentLowImpact())
            .commit()
    }
    private fun loadFragmentJ() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, ListFragmentFloor())
            .commit()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, SelectionActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
    }

}