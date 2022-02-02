package com.julio.rabbitvocabulary.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database( entities = [WordsInEnglish::class, WordsInPortuguese::class], version = 1)
abstract class WordDataBase : RoomDatabase() {

    abstract fun wordDao() : WordDao

    companion object{
        fun getDataBaseInstance (context : Context) : WordDataBase{
            return Room.databaseBuilder(context, WordDataBase::class.java, "word-database"
            ).build()
        }
    }
}