package a06367.apicture.network.api

import a06367.apicture.data.model.ImageListItem
import a06367.apicture.utils.Constants.Companion.QUERY_PER_PAGE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumApi {

    @GET("v2/list")
    suspend fun getImages(
        @Query("page")
        pageNumber: Int = 1,
        @Query("limit")
        pageSize: Int = QUERY_PER_PAGE
    ): Response<List<ImageListItem>>
}