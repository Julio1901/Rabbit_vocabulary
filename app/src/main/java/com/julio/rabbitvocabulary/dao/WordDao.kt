package com.julio.rabbitvocabulary.dao

import androidx.room.*

@Dao
interface WordDao {

    //English requests
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEnglishWord(wordsInEnglish: WordsInEnglish)

    @Update
    fun updateEnglishWord(wordsInEnglish: WordsInEnglish)

    @Delete
    fun deleteEnglishWord(wordsInEnglish: WordsInEnglish)

    @Query("SELECT * from words_in_english")
    fun getAllEnglishWords() : List<WordsInEnglish>

    //Portuguese requests
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPortugueseWord(wordsInPortuguese: WordsInPortuguese)

    @Update
    fun updatePortugueseWord(wordsInPortuguese: WordsInPortuguese)

    @Delete
    fun deletePortugueseWord(wordsInPortuguese: WordsInPortuguese)

    @Query("SELECT * FROM words_in_portuguese")
    fun getAllPortugueseWords() : List<WordsInPortuguese>
}