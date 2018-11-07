package com.example.nikit.kotlintest.model

import com.google.gson.annotations.SerializedName

class Meta{
    @SerializedName("success")
    var success:Boolean = false

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message:String =""

}