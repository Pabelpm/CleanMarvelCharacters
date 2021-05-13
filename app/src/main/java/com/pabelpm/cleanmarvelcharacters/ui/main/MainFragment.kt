package com.pabelpm.cleanmarvelcharacters.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.pabelpm.cleanmarvelcharacters.R
import com.pabelpm.cleanmarvelcharacters.databinding.MainFragmentBinding
import com.pabelpm.cleanmarvelcharacters.ui.adapters.MarvelCharactersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var adapter: MarvelCharactersAdapter
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        viewModel.getMarvelCharacters()

        viewModel.navigateToMarvelCharacterDetails.observe(viewLifecycleOwner, Observer {
                marvelCharacter ->
                val action = MainFragmentDirections.actionMainFragmentToMarvelCharacterDetailsFragment(marvelCharacter.id)
                navController.navigate(action)
            })

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this@MainFragment
        adapter = MarvelCharactersAdapter(viewModel::onMarvelCharacterClicked)
        binding.marvelCharactersRecyclerView.adapter = adapter
    }
}