package com.pabelpm.cleanmarvelcharacters.ui

import androidx.navigation.findNavController
import com.pabelpm.cleanmarvelcharacters.R
import com.pabelpm.cleanmarvelcharacters.databinding.NavigationHostActivityBinding
import com.pabelpm.cleanmarvelcharacters.ui.main.MainFragment
import com.pabelpm.cleanmarvelcharacters.ui.marvelcharacterdetails.MarvelCharacterDetailsFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationHostActivity : BaseActivity() {

    private lateinit var binding: NavigationHostActivityBinding

    override fun initializeView() {
        binding = NavigationHostActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.navigation_host_fragment)
        val action = MarvelCharacterDetailsFragmentDirections.actionMarvelCharacterDetailsFragmentToMainFragment()
        navController.navigate(action)
        //TO DO("Refactor by fragment with callback https://developer.android.com/guide/navigation/navigation-custom-back")
    }
}