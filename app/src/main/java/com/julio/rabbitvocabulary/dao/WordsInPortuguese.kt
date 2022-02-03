package com.julio.rabbitvocabulary.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_in_portuguese")
data class WordsInPortuguese(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val word: String,
    val description : String
)
