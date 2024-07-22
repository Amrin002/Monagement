package com.lctproduction.monagement

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lctproduction.monagement.databinding.ActivityMainBinding
import com.lctproduction.monagement.fragments.HomeFragment
import com.lctproduction.monagement.fragments.SettingsFragment
import com.lctproduction.monagement.fragments.StatistikFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Declare the binding object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Initialize the binding object
        enableEdgeToEdge()
        setContentView(binding.root) // Set the content view using the binding object
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets -> // Use binding to reference views
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragmentContainer : FrameLayout = binding.fragementContainer
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_stat -> {
                    loadFragment(StatistikFragment())
                    true
                }
                R.id.nav_settings -> {
                    loadFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragementContainer,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}