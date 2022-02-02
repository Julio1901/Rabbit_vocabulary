package com.julio.rabbitvocabulary.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.julio.rabbitvocabulary.R
import com.julio.rabbitvocabulary.util.AppLanguageOptions
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule


class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Test
    fun `default language value as English in View Model creation`(){
        val mainViewModel = MainViewModel()
        assertEquals("Success", AppLanguageOptions.ENGLISH, mainViewModel.appLanguage.value)
    }

    @Test
    fun `change app language to change fragments behavior `(){

        val mainViewModel =  MainViewModel()

        mainViewModel.changeAppLanguage()
        assertEquals("Changed to Portuguese", AppLanguageOptions.PORTUGUESE, mainViewModel.appLanguage.value)

        mainViewModel.changeAppLanguage()
        assertEquals("Changed to English", AppLanguageOptions.ENGLISH, mainViewModel.appLanguage.value)

    }


    @Test
    fun `returns appropriate string when language is in English`(){
        val mainViewModel = MainViewModel()
        assertEquals(R.string.write_the_translation, mainViewModel.changeWordAdditionFormByCurrentlySelectedLanguage())
    }

    @Test
    fun `return appropriate string when language changed to Portuguese`(){
        val mainViewModel = MainViewModel()
        mainViewModel.changeAppLanguage()
        assertEquals(R.string.enter_description, mainViewModel.changeWordAdditionFormByCurrentlySelectedLanguage())
    }

}