package com.korea.hacks.service.api

import com.korea.hacks.model.response.User
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("api/user/list")
    fun getUserList(): Single<Response<MutableList<User>>>

    @GET("api/user/profile")
    fun getUserProfile()
}