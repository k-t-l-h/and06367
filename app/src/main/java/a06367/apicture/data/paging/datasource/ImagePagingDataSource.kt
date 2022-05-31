package a06367.apicture.data.paging.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import a06367.apicture.data.model.ImageListItem
import a06367.apicture.network.api.PicsumApi
import a06367.apicture.utils.Constants.Companion.TOTAL_PAGES

class ImagePagingDataSource(private val service: PicsumApi) :
    PagingSource<Int, ImageListItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageListItem> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getImages(pageNumber)
            val pagedResponse = response.body()

            var nextPageNumber: Int? = null
            if (pageNumber < TOTAL_PAGES) {
                nextPageNumber = pageNumber + 1
            }

            LoadResult.Page(
                data = pagedResponse.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImageListItem>): Int = 1
}