package com.aryanvedh.vocab.database

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    val allWords : LiveData<List<Word>> = wordDao.getAllWord()

    suspend fun insertWord(word: Word){
        wordDao.insertWord(word)
    }

    suspend fun updateWord(word: Word){
        wordDao.updateWord(word)
    }

    suspend fun deleteWord(word: Word){
        wordDao.deleteWord(word)
    }

}