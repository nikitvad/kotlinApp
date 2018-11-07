package com.example.nikit.kotlintest.di.modules

import com.example.nikit.kotlintest.model.BaseModel
import com.example.nikit.kotlintest.model.User
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface Api{
    companion object {
        const val BASE_URL:String = "https://gorest.co.in/"
    }

    @GET("public-api/users?_format=json&access-token=ggolvSv4UpUH_a9Qk5x5KAC2YudbptpltVYZ")
    fun getAllUsers(): Observable<Response<BaseModel<User>>>

    @GET("public-api/posts?_format=json")
    fun getAllPosts()

    @GET("public-api/users/")
    fun findUser(@Query("name") name:String)

}
