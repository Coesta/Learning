package com.leocoesta.roomwordsamplekt

import android.arch.lifecycle.LiveData

class WordRepository(val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}