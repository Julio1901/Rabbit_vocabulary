package com.julio.rabbitvocabulary.di

import com.julio.rabbitvocabulary.dao.repository.WordRepository
import com.julio.rabbitvocabulary.viewmodel.MainViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val viewModelModule = module {

    viewModel {(wordRepository: WordRepository) -> MainViewModel(wordRepository) }

}