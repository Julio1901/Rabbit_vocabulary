package com.julio.rabbitvocabulary.dao.repository

import android.content.Context
import com.julio.rabbitvocabulary.dao.WordDataBase
import com.julio.rabbitvocabulary.dao.WordsInEnglish
import com.julio.rabbitvocabulary.dao.WordsInPortuguese
import com.julio.rabbitvocabulary.util.AppLanguageOptions
import com.julio.rabbitvocabulary.util.GenericWordEntity

class WordRepository (context: Context) {

    private val dbInstance = WordDataBase.getDataBaseInstance(context)
    private val dao = dbInstance.wordDao()

    fun saveWord(languageSelected : AppLanguageOptions, word : String, translationOrDescription : String){

        when(languageSelected){
            AppLanguageOptions.ENGLISH ->{
                val newWord = WordsInEnglish(0, word, translationOrDescription)
                dao.insertEnglishWord(newWord)
            }
            AppLanguageOptions.PORTUGUESE->{
                val newWord = WordsInPortuguese(0, word, translationOrDescription)
                dao.insertPortugueseWord(newWord)
            }
        }
    }

    fun updateWord(languageSelected: AppLanguageOptions, word: String, translationOrDescription: String){

        when(languageSelected){
            AppLanguageOptions.ENGLISH ->{
                val newWord = WordsInEnglish(0, word, translationOrDescription)
                dao.updateEnglishWord(newWord)
            }
            AppLanguageOptions.PORTUGUESE->{
                val newWord = WordsInPortuguese(0, word, translationOrDescription)
                dao.updatePortugueseWord(newWord)
            }
        }
    }


    fun deleteWord(languageSelected: AppLanguageOptions, word: String, translationOrDescription: String){

        when(languageSelected){
            AppLanguageOptions.ENGLISH ->{
                val newWord = WordsInEnglish(0, word, translationOrDescription)
                dao.deleteEnglishWord(newWord)
            }
            AppLanguageOptions.PORTUGUESE->{
                val newWord = WordsInPortuguese(0, word, translationOrDescription)
                dao.deletePortugueseWord(newWord)
            }
        }
    }

    fun getAllWords(languageSelected: AppLanguageOptions) : List<GenericWordEntity>{

        val genericWordsList = mutableListOf<GenericWordEntity>()

        when(languageSelected){
            AppLanguageOptions.ENGLISH ->{
                val response = dao.getAllEnglishWords()

                response.forEach {
                    val newWord = GenericWordEntity(it.word, it.translate)
                    genericWordsList.add(newWord)
                }
            }
            AppLanguageOptions.PORTUGUESE ->{
                val response = dao.getAllPortugueseWords()

                response.forEach {
                    val newWord = GenericWordEntity(it.word, it.description)
                    genericWordsList.add(newWord)
                }
            }
        }

        return genericWordsList
    }
}