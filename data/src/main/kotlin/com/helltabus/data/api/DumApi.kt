package com.helltabus.data.api

import com.helltabus.data.request.DaangnDto
import com.helltabus.data.response.Dum
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DumApi {
    @GET("/{path}")
    fun getDumUser(
        @Path("path") id: String
    ): Dum

    @POST("/")
    fun postDumUser(
        @Body daangn: DaangnDto
    ): Dum
}