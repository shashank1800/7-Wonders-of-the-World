package com.shashankbhat.sevenwondersofworld.api

import okhttp3.ResponseBody
import retrofit2.Call

import retrofit2.http.GET




/**
 * Created by SHASHANK BHAT on 05-Jun-20.
 *
 *
 */

public interface API{
    @GET("data.json")
    fun getData(): Call<ResponseBody?>?
}