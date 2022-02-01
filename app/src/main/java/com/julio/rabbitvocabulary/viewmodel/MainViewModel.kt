package com.julio.rabbitvocabulary.viewmodel


import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.julio.rabbitvocabulary.R
import androidx.lifecycle.ViewModel
import com.julio.rabbitvocabulary.util.AppLanguageOptions


class MainViewModel : ViewModel() {

     val appLanguage = MutableLiveData<AppLanguageOptions>(AppLanguageOptions.ENGLISH)



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
}