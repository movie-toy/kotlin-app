package com.toy.movietoy.utils

object Constants {
    const val TAG: String = "로그"
}

object API {
    const val BASE_URL: String = "https://api.unsplash.com/"
    const val CLIENT_ID: String = "qrG5C9FQ9quBHB0wGabkUKXRVkXZzYCBHazO7PWTXBg"

    const val SEARCH_PHOTOS: String = "search/photos"
    const val SEARCH_USERS: String = "search/users"
}

enum class RESPONSE_STATUS {
    OKAY,
    FAIL,
    NO_CONTENT
}