package com.pabelpm.cleanmarvelcharacters.ui.marvelcharacterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pabelpm.cleanmarvelcharacters.databinding.MarvelCharacterDetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelCharacterDetailsFragment : Fragment() {

    private val viewModel: MarvelCharacterDetailsViewModel by viewModels()
    private lateinit var binding: MarvelCharacterDetailsFragmentBinding
    val args: MarvelCharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MarvelCharacterDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this@MarvelCharacterDetailsFragment

        viewModel.getMarvelCharacter(args.id)
    }
}