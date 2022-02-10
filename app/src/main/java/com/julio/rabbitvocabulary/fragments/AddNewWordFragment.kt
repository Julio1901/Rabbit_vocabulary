package com.julio.rabbitvocabulary.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.julio.rabbitvocabulary.R
import com.julio.rabbitvocabulary.dao.repository.WordRepository
import com.julio.rabbitvocabulary.databinding.FragmentAddNewWordBinding
import com.julio.rabbitvocabulary.util.AppLanguageOptions
import com.julio.rabbitvocabulary.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


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
        val inputWord : TextInputEditText = binding.inputWordEditText
        val inputTranslateOrDescription : EditText = binding.translateOrDescriptionEditText

        val mainViewModel : MainViewModel by viewModel{
            parametersOf(WordRepository(binding.root.context))
        }


        inputTranslateTitle.text = getString(mainViewModel.changeWordAdditionFormByCurrentlySelectedLanguage())




        btnBackToHome.setOnClickListener {
            val action = AddNewWordFragmentDirections.actionAddNewWordFragmentToHomeFragment()
            view.findNavController().navigate(action)
        }

        btnSaveWord.setOnClickListener {
            //TODO: Replace this verification
            if (inputWord.text.toString() != "" || inputTranslateOrDescription.text.toString() != ""){
                mainViewModel.saveWord(inputWord.text.toString(), inputTranslateOrDescription.text.toString())
            }
        }




    }

}