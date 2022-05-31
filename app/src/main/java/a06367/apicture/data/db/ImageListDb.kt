package a06367.apicture.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import a06367.apicture.data.db.dao.ImageListDao
import a06367.apicture.data.db.dao.PageKeyDao
import a06367.apicture.data.model.ImageListItem
import a06367.apicture.data.model.PageKey

@Database(
    entities = [ImageListItem::class, PageKey::class],
    version = 1,
    exportSchema = false
)
abstract class ImageListDb : RoomDatabase() {

    abstract fun getImageListDao(): ImageListDao
    abstract fun pageKeyDao(): PageKeyDao

    companion object {
        @Volatile
        private var instance: ImageListDb? = null

        fun getDatabase(context: Context): ImageListDb =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        //Build a local database to store data
        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, ImageListDb::class.java, "picsum_db")
                .fallbackToDestructiveMigration()
                .build()
    }
}