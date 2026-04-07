package cat.example.exam3.retrofit

import cat.example.exam3.data.LoginRequest
import cat.example.exam3.data.LoginResponse
import cat.example.exam3.data.MaterialData
import cat.example.exam3.data.UsuariData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {

    @GET("/reserves/usuari/{idusuari}")
    suspend fun getMaterial(@Path("idusuari") id:Int): List<MaterialData>

    @POST("/login/")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}