package com.example.citiesapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.citiesapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = fragHost.navController

        setupWithNavController(binding.bottomNavigation, navController)


        binding.floatingActionButton.setOnClickListener {


            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "esraa.fathy225@gmail.com")
            intent.putExtra(Intent.EXTRA_TEXT, "How are you?")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }

    }
}
