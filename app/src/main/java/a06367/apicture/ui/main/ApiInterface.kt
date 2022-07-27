package a06367.apicture.ui.main

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("v2/list")
    fun getData(): Call<List<StarredData>>

}