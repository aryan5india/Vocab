package com.aryanvedh.vocab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomMenu = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentHost)
        bottomMenu.setupWithNavController(navController)

        setupActionBarWithNavController(findNavController(R.id.fragmentHost))

    }

   override fun onSupportNavigateUp():Boolean{
        val navCon = findNavController(R.id.fragmentHost)
        return navCon.navigateUp() || super.onSupportNavigateUp()
    }


}




