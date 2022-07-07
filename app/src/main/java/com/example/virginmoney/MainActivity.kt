package com.example.virginmoney

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.virginmoney.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.navigation_colleagues || nd.id == R.id.navigation_rooms) {
                navView.visibility = View.VISIBLE
            } else {
                navView.visibility = View.GONE
            }
           // val appBarConfiguration = AppBarConfiguration(
             //   setOf(
               //     R.id.navigation_colleagues, R.id.navigation_rooms
                //)
            //)

            //setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }

    }

//    override fun onBackPressed() {
//        if (supportFragmentManager.backStackEntryCount > 0) {
//            supportFragmentManager.popBackStack()
//        } else {
//            super.onBackPressed()
//        }
//    }
}