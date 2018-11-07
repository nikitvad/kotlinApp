package com.example.nikit.kotlintest.model

import com.google.gson.annotations.SerializedName

data class BaseModel<T>(@SerializedName("_meta")
                        var meta: Meta?) {


//    @SerializedName("result")
//    lateinit var list: List<T>
}