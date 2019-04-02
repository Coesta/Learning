package com.leocoesta.roomwordsamplekt

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Cria a base aqui
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java,
                        "WordDatabase")
                        .build()
                INSTANCE = instance
                instance
            }
        }
    }
}