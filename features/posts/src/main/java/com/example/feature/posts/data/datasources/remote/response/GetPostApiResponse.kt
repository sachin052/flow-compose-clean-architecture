package com.example.feature.posts.data.datasources.remote.response


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class GetPostApiResponse : ArrayList<GetPostApiResponse.GetPostApiResponseItem>(){
    @Keep
    data class GetPostApiResponseItem(
        @SerializedName("body")
        val body: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("userId")
        val userId: Int
    )
}