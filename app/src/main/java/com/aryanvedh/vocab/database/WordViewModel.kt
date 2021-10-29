package com.aryanvedh.vocab.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    var allWords: LiveData<List<Word>>
    private var repository : WordRepository

    init {
        val dao = WordDatabase.getDatabase(application)?.wordDao()
        repository = WordRepository(dao!!)
        allWords = repository.allWords
    }


    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertWord(word)
    }

    fun delete(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteWord(word)
    }

    fun update(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateWord(word)
    }
}

