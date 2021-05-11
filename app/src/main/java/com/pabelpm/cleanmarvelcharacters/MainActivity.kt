package com.pabelpm.cleanmarvelcharacters

import androidx.activity.viewModels
import com.pabelpm.cleanmarvelcharacters.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun initializeView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}