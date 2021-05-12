package com.pabelpm.cleanmarvelcharacters.ui.main

import com.pabelpm.cleanmarvelcharacters.R
import com.pabelpm.cleanmarvelcharacters.databinding.MainActivityBinding
import com.pabelpm.cleanmarvelcharacters.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: MainActivityBinding

    override fun initializeView() {
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.root_container, MainFragment())
            .commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStackImmediate() else super.onBackPressed()
    }
}