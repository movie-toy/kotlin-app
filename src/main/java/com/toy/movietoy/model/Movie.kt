package com.toy.movietoy.model

import java.io.Serializable

data class Movie(val profile: String?,
                var title: String?,
                var createdAt: String?): Serializable {
}

data class Photo(val thumbnail: String?,
                 var author: String?,
                 var createdAt: String?,
                 var likesCount: Int?): Serializable {
}