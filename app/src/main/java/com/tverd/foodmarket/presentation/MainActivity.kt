package com.tverd.foodmarket.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.tverd.foodmarket.R
import com.tverd.foodmarket.databinding.ActivityMainBinding
import com.tverd.foodmarket.presentation.account.AccountViewModel
import com.tverd.foodmarket.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    private lateinit var navController: NavController
    private lateinit var appBarConf: AppBarConfiguration

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        vm.delProds()
        vm.checkClient()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConf = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.accountFragment, R.id.cartFragment, R.id.settingsFragment),
            binding!!.drawerLayout
        )

        setSupportActionBar(binding!!.toolbar)
        setupActionBarWithNavController(navController, appBarConf)

        binding!!.navView.setupWithNavController(navController)
        binding!!.bottomNavView.setupWithNavController(navController)

        vm.currClient.observe(this) {
            val header = binding!!.navView.getHeaderView(0)
            header.findViewById<TextView>(R.id.sidebar_name).text = it.clientLastName + it.clientFirstName
            header.findViewById<TextView>(R.id.sidebar_email).text = it.clientEmail
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConf) || super.onSupportNavigateUp()
    }
}