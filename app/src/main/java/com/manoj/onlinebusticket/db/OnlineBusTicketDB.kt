package com.manoj.onlinebusticket.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manoj.onlinebusticket.dao.UserDAO
import com.manoj.onlinebusticket.entity.User


@Database(
    entities = [(User::class)],
    version = 1
)

abstract class OnlineBusTicketDB: RoomDatabase() {
    abstract fun getUserDao(): UserDAO

    companion object{
        @Volatile
        private var instance : OnlineBusTicketDB? = null

        fun getInstance(context: Context): OnlineBusTicketDB{
            if (instance==null){
                synchronized(OnlineBusTicketDB::class){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                OnlineBusTicketDB::class.java,
                "OnlineBusTicketDB"
            ).build()
    }
}