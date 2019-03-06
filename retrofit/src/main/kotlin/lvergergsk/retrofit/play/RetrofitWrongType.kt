package lvergergsk.retrofit.play

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import reactor.core.publisher.Mono
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

class RetrofitWrongType{
    private val retrofit = createReactorRetrofitBuilder(client)
        .baseUrl("http://spider.air.line-apps-dev.com:8080")
        .build()
        .create(AirGoApi::class.java)

    data class ExpectedStructure(
        val id: Int,
        val message: String
    )

    data class WrongStructure(
        val something: String
    )
}

interface AirGoApi {
    @Multipart
    @POST("/v1.0/oriapk")
    fun upload(@Part("file\"; filename=\"file.apk\" ") file: RequestBody): Mono<Response<AirUploadResult>>

    @POST("/v2.0/build/")
    fun build(@Body request: AirRequest): Mono<Response<AirResponse>>
}

fun createReactorRetrofitBuilder(client: OkHttpClient): Retrofit.Builder = Retrofit.Builder()
    .client(client)
    .addConverterFactory(JacksonConverterFactory.create(createObjectMapper()))
    .addCallAdapterFactory(ReactorCallAdapterFactory.createAsync())
