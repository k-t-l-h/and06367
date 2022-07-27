package a06367.apicture.data.model

import androidx.room.PrimaryKey
import java.io.Serializable

data class ImageCollection (
    @PrimaryKey()
    val id: String = "1",
    val author: String?,
    val download_url: String?,
    val height: Int?,
    val url: String?,
    val width: Int?,
) : Serializable