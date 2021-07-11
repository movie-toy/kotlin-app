package com.toy.movietoy.retrofit

import android.util.Log
import com.google.gson.JsonElement
import com.toy.movietoy.model.Photo
import com.toy.movietoy.utils.API
import com.toy.movietoy.utils.Constants.TAG
import com.toy.movietoy.utils.RESPONSE_STATUS
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    // 인물 검색 api 호출
    fun searchUsers(searchTerm: String?, completion: (RESPONSE_STATUS, ArrayList<Photo>?) -> Unit){

//        val term = searchTerm.let {
//            it
//        }?: ""
//        val call = iRetrofit?.search(searchTerm = term).let {
//            it
//        }?: ""
        val term = searchTerm ?: ""
        val call = iRetrofit?.searchPhoto(searchTerm = term) ?: return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            // 응답 실패 시
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG,"RetrofitManager - onFailure() called / t: $t")
                completion(RESPONSE_STATUS.FAIL, null)
            }
            // 응답 성공 시
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG,"RetrofitManager - onResponse() called / response : ${response.body()}")

                when(response.code()){
                    200 -> {
                        response.body()?.let {
                            var parsePhotoDataArray = ArrayList<Photo>()

                            val body = it.asJsonObject
                            val results = body.getAsJsonArray("results")
                            val total = body.get("total").asInt
                            Log.d(TAG,"RetrofitManager - onResponse() called / total $total")

                            // 데이터가 없는 경우 no_content
                            if(total == 0) {
                                completion(RESPONSE_STATUS.NO_CONTENT, null)
                            } else {
                                results.forEach { resultItem ->
                                    val resultItemObject = resultItem.asJsonObject
                                    val user = resultItemObject.get("user").asJsonObject
                                    val username: String = user.get("username").asString
                                    val likesCount = resultItemObject.get("likes").asInt
                                    val thumbnailLink = resultItemObject.get("urls").asJsonObject.get("thumb").asString
                                    val createdAt = resultItemObject.get("created_at").asString

                                    val parser = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss")
                                    val formatter = SimpleDateFormat("yyyy년\nMM월 dd일")
                                    val outputDateString = formatter.format(parser.parse(createdAt))
                                    Log.d(TAG,"RetrofitManager - outputDateString: $outputDateString")

                                    val photoItem = Photo(
                                        author = username,
                                        likesCount = likesCount,
                                        thumbnail = thumbnailLink,
                                        createdAt = outputDateString
                                    )
                                    parsePhotoDataArray.add(photoItem)
                                }
                                completion(RESPONSE_STATUS.OKAY, parsePhotoDataArray)
                            }
                        }
                    }
                }
            }
        })
    }
}