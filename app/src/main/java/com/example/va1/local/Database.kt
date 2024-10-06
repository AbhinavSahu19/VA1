package com.example.va1.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BlogRDC::class],
    version = 1
)
abstract class BlogDatabase: RoomDatabase() {
    abstract val dao: BlogDao
}