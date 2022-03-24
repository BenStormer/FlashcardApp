package com.example.bensflashcardapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.bensflashcardapp.Flashcard.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract com.example.bensflashcardapp.FlashcardDao flashcardDao();
}
