package com.pabelpm.cleanmarvelcharacters.ui.main

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pabelpm.cleanmarvelcharacters.databinding.MainFragmentBinding
import com.pabelpm.cleanmarvelcharacters.ui.adapters.MarvelCharactersAdapter
import com.pabelpm.cleanmarvelcharacters.ui.toast
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
        setupSearchView()
        viewModel.getMarvelCharacters()

        //region Observable
        viewModel.navigateToMarvelCharacterDetails.observe(viewLifecycleOwner, Observer {
                marvelCharacterId ->
                val action = MainFragmentDirections.actionMainFragmentToMarvelCharacterDetailsFragment(marvelCharacterId)
                navController.navigate(action)
            })
        //endregion

        //region Bindings
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this@MainFragment
        adapter = MarvelCharactersAdapter(viewModel::onMarvelCharacterClicked)
        binding.marvelCharactersRecyclerView.adapter = adapter

        binding.marvelCharacterIdSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query!=null) {
                    try {
                        viewModel.getMarvelCharacter(query)
                    }catch (e: Exception){
                        activity?.toast("Only can write numbers")
                    }
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                //Not needed only want call to server
                return false
            }
        })

        binding.marvelCharactersRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.getMarvelCharacters()
                    //TO DO block ui loading until response and load adapter and not recall sometimes
                }
            }
        })
        //endregion
    }


    private fun setupSearchView() {
        binding.marvelCharacterIdSearchView.inputType = InputType.TYPE_CLASS_NUMBER
        binding.marvelCharacterIdSearchView.queryHint = "Write a marvel identifier";
    }
}