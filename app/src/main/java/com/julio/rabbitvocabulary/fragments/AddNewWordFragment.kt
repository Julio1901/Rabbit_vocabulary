package com.julio.rabbitvocabulary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.julio.rabbitvocabulary.R
import com.julio.rabbitvocabulary.databinding.FragmentAddNewWordBinding


class AddNewWordFragment : Fragment() {

    private var _binding : FragmentAddNewWordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBackToHome : FloatingActionButton = binding.btnBackToHome

        btnBackToHome.setOnClickListener {
            val action = AddNewWordFragmentDirections.actionAddNewWordFragmentToHomeFragment()
            view.findNavController().navigate(action)
        }

    }

}