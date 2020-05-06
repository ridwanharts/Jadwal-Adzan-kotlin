package com.ridwanharts.jadwaladzan.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ridwanharts.jadwaladzan.data.db.entities.Data
import com.ridwanharts.jadwaladzan.data.db.entities.Jadwal

@Database(
    entities = [Data::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getDataDao() : DataDao

    companion object{
        @Volatile
        private var instance : AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "MyDatabase.db"
            ).build()
    }
}