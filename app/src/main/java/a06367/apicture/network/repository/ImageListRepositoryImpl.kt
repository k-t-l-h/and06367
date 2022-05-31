package a06367.apicture.network.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import a06367.apicture.data.db.ImageListDb
import a06367.apicture.data.db.dao.ImageListDao
import a06367.apicture.data.model.ImageListItem
import a06367.apicture.data.paging.datasource.ImagePagingDataSource
import a06367.apicture.data.paging.remotemediator.ImageListRemoteMediator
import a06367.apicture.network.api.PicsumApi
import a06367.apicture.utils.Constants.Companion.QUERY_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class ImageListRepositoryImpl @Inject constructor(
    private val picsumApi: PicsumApi,
    private val localDataSource: ImageListDao,
    private val imageListDb: ImageListDb
) : ImageListRepository {

    override suspend fun getImages(): Flow<PagingData<ImageListItem>> {
        val pagingSourceRemote = { ImagePagingDataSource(picsumApi) }
        val pagingSourceLocal = { imageListDb.getImageListDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = QUERY_PER_PAGE, prefetchDistance = 2),
            remoteMediator = ImageListRemoteMediator(picsumApi, imageListDb),
            pagingSourceFactory = pagingSourceLocal
        ).flow
    }

    override suspend fun saveImageItem(item: ImageListItem) = localDataSource.upsert(item)

    override suspend fun getSavedImages() = localDataSource.getAllImages()

    override suspend fun getSavedImagesList() = localDataSource.getAllImagesList()

    override
    suspend fun deleteAllImages() = localDataSource.deleteAllImages()
}