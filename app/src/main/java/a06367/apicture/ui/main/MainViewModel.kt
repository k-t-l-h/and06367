package a06367.apicture.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import a06367.apicture.base.BaseViewModel
import a06367.apicture.data.model.ImageListItem
import a06367.apicture.network.repository.ImageListRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
@ExperimentalPagingApi
class MainViewModel @Inject constructor(
    private val repository: ImageListRepositoryImpl
) : BaseViewModel() {

    private val TAG = "MainViewModel"
    private lateinit var _imageResponse: Flow<PagingData<ImageListItem>>
    val imageResponse: Flow<PagingData<ImageListItem>>
        get() = _imageResponse

    init {
        fetchImages()
    }

    private fun fetchImages() {
        launchPagingAsync({
            repository.getImages().cachedIn(viewModelScope)
        }, {
            _imageResponse = it
        })
    }
}