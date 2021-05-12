package com.pabelpm.cleanmarvelcharacters.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.pabelpm.cleanmarvelcharacters.R
import com.pabelpm.cleanmarvelcharacters.databinding.MainFragmentBinding
import com.pabelpm.cleanmarvelcharacters.ui.adapters.MarvelCharactersAdapter
import com.pabelpm.cleanmarvelcharacters.ui.marvelCharacterDetails.MarvelCharacterDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
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

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        adapter = MarvelCharactersAdapter(viewModel::onMarvelCharacterClicked)
        binding.marvelCharactersRecyclerView.adapter = adapter

        viewModel.getMarvelCharacters()

        viewModel.navigateToMarvelCharacterDetail.observe(
            viewLifecycleOwner,
            Observer { marvelCharacter ->
                activity?.supportFragmentManager?.beginTransaction()
                    ?.add(R.id.root_container, MarvelCharacterDetailsFragment())
                    ?.addToBackStack("MarvelCharacterDetailsFragment")?.commit()
            })
    }
}