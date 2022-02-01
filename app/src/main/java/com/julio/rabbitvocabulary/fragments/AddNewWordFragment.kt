package com.julio.rabbitvocabulary.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.julio.rabbitvocabulary.R
import com.julio.rabbitvocabulary.databinding.FragmentAddNewWordBinding
import com.julio.rabbitvocabulary.util.AppLanguageOptions
import com.julio.rabbitvocabulary.viewmodel.MainViewModel


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
        val btnSaveWord : AppCompatButton = binding.btnSaveWord
        val inputTranslateTitle : TextView = binding.inputTranslateTitle
        val mainViewModel : MainViewModel by activityViewModels()

        inputTranslateTitle.text = getString(mainViewModel.changeWordAdditionFormByCurrentlySelectedLanguage())




        btnBackToHome.setOnClickListener {
            val action = AddNewWordFragmentDirections.actionAddNewWordFragmentToHomeFragment()
            view.findNavController().navigate(action)
        }

        btnSaveWord.setOnClickListener {
            if(mainViewModel.appLanguage.value == AppLanguageOptions.ENGLISH ){
                Log.e("Language", "Ingles")
            }else if (mainViewModel.appLanguage.value == AppLanguageOptions.PORTUGUESE){
                Log.e("Language", "Portugues")
            }
            else if (mainViewModel.appLanguage.value == null){
                Log.e("Language", "then has null")
            }
        }




    }

}