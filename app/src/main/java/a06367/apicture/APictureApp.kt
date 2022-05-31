package a06367.apicture
import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import kotlin.text.Typography.dagger

@HiltAndroidApp
class APictureApp: Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: APictureApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}
