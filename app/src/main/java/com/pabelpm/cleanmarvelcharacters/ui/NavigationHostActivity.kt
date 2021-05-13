package com.pabelpm.cleanmarvelcharacters.ui

import com.pabelpm.cleanmarvelcharacters.R
import com.pabelpm.cleanmarvelcharacters.databinding.NavigationHostActivityBinding
import com.pabelpm.cleanmarvelcharacters.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationHostActivity : BaseActivity() {

    private lateinit var binding: NavigationHostActivityBinding

    override fun initializeView() {
        binding = NavigationHostActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}