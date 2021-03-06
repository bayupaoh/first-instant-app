package com.suitmedia.sample.data.api

import com.suitmedia.sample.data.api.wrapper.Results
import com.suitmedia.sample.data.api.model.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by DODYDMW19 on 8/3/2017.
 */

interface APIService {

    @GET("users")
    fun getMembers(
            @Query("per_page") perPage: Int,
            @Query("page") page: Int): Flowable<Results<User>>

}
