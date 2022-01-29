package com.julio.rabbitvocabulary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.julio.rabbitvocabulary.R
import com.julio.rabbitvocabulary.databinding.FragmentTranslateTheWordGameBinding

class TranslateTheWordGameFragment : Fragment() {

    private var _binding : FragmentTranslateTheWordGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTranslateTheWordGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBackToHome : FloatingActionButton = binding.btnBackToHome

        btnBackToHome.setOnClickListener {
            val action = TranslateTheWordGameFragmentDirections.actionTranslateTheWordGameFragmentToShowGamesFragment()
            view.findNavController().navigate(action)
        }

    }

}