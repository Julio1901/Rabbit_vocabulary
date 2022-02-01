package com.julio.rabbitvocabulary.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.julio.rabbitvocabulary.R
import com.julio.rabbitvocabulary.databinding.FragmentHomeBinding
import com.julio.rabbitvocabulary.util.AppLanguageOptions
import com.julio.rabbitvocabulary.viewmodel.MainViewModel


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardListAllWords : View = binding.cardListAllWords
        val cardAddNewWord : View = binding.cardAddNewWord
        val cardShowGames : View = binding.cardShowGames
        val switchLanguage : Switch = binding.languageSelectionSwitchButton
        val mainViewModel : MainViewModel by activityViewModels()

        cardListAllWords.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDisplayAllWordsFragment()
            view.findNavController().navigate(action)
        }

        cardAddNewWord.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddNewWordFragment()
            view.findNavController().navigate(action)
        }

        cardShowGames.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToShowGamesFragment()
            view.findNavController().navigate(action)
        }


            if (mainViewModel.appLanguage.value == AppLanguageOptions.PORTUGUESE){
                switchLanguage.setChecked(true)
            }else{
                switchLanguage.setChecked(false)
            }


        switchLanguage.setOnCheckedChangeListener { compoundButton, b ->
            if(compoundButton.isChecked){
                mainViewModel.changeAppLanguage()
            }else{
                mainViewModel.changeAppLanguage()
            }

            Log.e("Linguagem alterada", mainViewModel.appLanguage.value.toString())
        }

    }


}