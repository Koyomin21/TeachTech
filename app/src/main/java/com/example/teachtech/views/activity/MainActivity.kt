package com.example.teachtech.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.teachtech.R
import com.example.teachtech.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.landingFragment -> binding.navigation.visibility = View.GONE
                R.id.entryFragment -> binding.navigation.visibility = View.GONE
                R.id.signUpFragment -> binding.navigation.visibility = View.GONE
                R.id.loginFragment -> binding.navigation.visibility = View.GONE
                else -> binding.navigation.visibility = View.VISIBLE
            }

        }
    }
}

