package com.manoj.guitarhero.db
//
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manoj.guitarhero.dao.BlogDAO
import com.manoj.guitarhero.dao.ProductDAO
import com.manoj.guitarhero.dao.UserDAO
import com.manoj.guitarhero.entity.Product
import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.model.BlogItem
import com.manoj.guitarhero.model.ProductItem


@Database(
    entities = [(User::class),(ProductItem::class),(BlogItem::class)],
    version = 1,
    exportSchema = false
)

abstract class GuitarHeroDB: RoomDatabase() {
    abstract fun getUserDao(): UserDAO
    abstract fun getProductDao(): ProductDAO
    abstract fun getBlogDao(): BlogDAO

    companion object{
        @Volatile
        private var instance : GuitarHeroDB? = null

        fun getInstance(context: Context): GuitarHeroDB{
            if (instance==null){
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