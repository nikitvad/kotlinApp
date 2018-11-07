package com.example.nikit.kotlintest.model

import com.google.gson.annotations.SerializedName

data class Links(
        @SerializedName("avatar")
        var avatar: AvatarX?,
        @SerializedName("self")
        var self: Self?
)