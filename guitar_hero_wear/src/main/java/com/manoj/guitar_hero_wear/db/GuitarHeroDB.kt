package com.manoj.guitar_hero_wear.db
//
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manoj.guitar_hero_wear.dao.UserDAO
import com.manoj.guitar_hero_wear.entity.User


@Database(
    entities = [(User::class)],
    version = 1,
    exportSchema = false
)

abstract class GuitarHeroDB: RoomDatabase() {
    abstract fun getUserDao(): UserDAO

    companion object{
        @Volatile
        private var instance : GuitarHeroDB? = null

        fun getInstance(context: Context): GuitarHeroDB {
            if (instance ==null){
                synchronized(GuitarHeroDB::class){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GuitarHeroDB::class.java,
                "GuitarHeroDB"
            ).build()
    }
}