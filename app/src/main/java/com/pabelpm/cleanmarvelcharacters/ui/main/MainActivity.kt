package com.pabelpm.cleanmarvelcharacters.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.pabelpm.cleanmarvelcharacters.databinding.ActivityMainBinding
import com.pabelpm.cleanmarvelcharacters.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun initializeView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMarvelCharacters()
    }

    override fun observeViewModel() {
        viewModel.marvelCharactersLiveData.observe(
            this, Observer { marvelCharacterViewList ->
                println(marvelCharacterViewList[0].name)
            })
    }
}