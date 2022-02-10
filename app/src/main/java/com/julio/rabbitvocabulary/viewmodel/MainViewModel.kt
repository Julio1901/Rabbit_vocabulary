package com.julio.rabbitvocabulary.viewmodel


import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.julio.rabbitvocabulary.R
import androidx.lifecycle.ViewModel
import com.julio.rabbitvocabulary.dao.repository.WordRepository
import com.julio.rabbitvocabulary.util.AppLanguageOptions
import com.julio.rabbitvocabulary.util.GenericWordEntity


class MainViewModel (private val wordRepository : WordRepository): ViewModel() {

     val appLanguage = MutableLiveData<AppLanguageOptions>(AppLanguageOptions.ENGLISH)
     val listAllWords = MutableLiveData<List<GenericWordEntity>>()

     fun changeAppLanguage(){
          if(appLanguage.value == AppLanguageOptions.ENGLISH){
               appLanguage.value = AppLanguageOptions.PORTUGUESE
          }else{
               appLanguage.value = AppLanguageOptions.ENGLISH
          }
     }

     fun changeWordAdditionFormByCurrentlySelectedLanguage() : Int{

          return if (appLanguage.value == AppLanguageOptions.ENGLISH){
               R.string.write_the_translation
          }else{
               R.string.enter_description
          }
     }

     fun saveWord(word : String, translationOrDescription : String){
          wordRepository.saveWord(appLanguage.value!!, word, translationOrDescription)
     }

     fun updateWord(word: String, translationOrDescription: String){
          wordRepository.updateWord(appLanguage.value!!, word, translationOrDescription)
     }

     fun deleteWord(word: String, translationOrDescription: String){
          wordRepository.deleteWord(appLanguage.value!!, word, translationOrDescription)
     }

     fun getAllWords() {
          val listResponse : List<GenericWordEntity> = wordRepository.getAllWords(appLanguage.value!!)
          listAllWords.value = listResponse
     }

}