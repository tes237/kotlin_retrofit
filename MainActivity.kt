
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    //Okhttp3
    implementation 'com.squareup.okhttp3:okhttp:4.8.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.8.0'


<uses-permission android:name="android.permission.INTERNET"/>


import com.google.gson.annotations.SerializedName

data class SearchBookDto (
    @SerializedName("title") val title:String,
    @SerializedName("item") val books:List<Book>
)

import com.google.gson.annotations.SerializedName

data class Book (
    @SerializedName("itemId")val id:Long, //서버에서는 itemId라는 값을 가져와서,  app에선 id라는 값으로
    @SerializedName("title")val title:String,
    @SerializedName("description")val description:String,
    @SerializedName("coverSmallUrl")val coverSmallUrl:String

)

import com.google.gson.annotations.SerializedName

data class BestSellerDto (
    @SerializedName("title") val title:String,
    @SerializedName("item") val books:List<Book>

)

import com.google.gson.annotations.SerializedName

data class SearchBookDto (
    @SerializedName("title") val title:String,
    @SerializedName("item") val books:List<Book>
)




import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("/api/search.api?output=json")
    fun getBookbyName(
        @Query("key") apiKey:String, //요구하는 기본인자를 @Query형태로
        @Query("query") keyword: String

    ): Call<SearchBookDto> //반환하는 값SearchBookDto

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    fun getBestSeller(
        @Query("key") apiKey:String

    ):Call<BestSellerDto>
}

package com.ai.kottest001

import BestSellerDto
import BookService
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT_SEC = 20000L

class MainActivity : AppCompatActivity()
{
    inline fun <reified T> T.logi(message: String) = Log.i(T::class.java.simpleName, message)

    companion object
    {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
            connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
        }.build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()) // Json데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리
            .build() //레트로핏 구현체 완성!

        val bookService = retrofit.create(BookService::class.java) //retrofit객체 만듦!

        bookService.getBestSeller("38845BE9BD0EBEDF271A2D5BC770C5BEEBB2D38910F504545CE384C6692DA6D4")
            .enqueue(object: Callback<BestSellerDto>
            {
                override fun onFailure(call: Call<BestSellerDto>, t: Throwable)
                {
                    //todo 실패처리
                    Log.d(TAG,t.toString())
                }

                override fun onResponse(call: Call<BestSellerDto>, response: Response<BestSellerDto>)
                {
                    //todo 성공처리

                    if(response.isSuccessful.not())
                    {
                        return
                    }
                    response.body()?.let {
                        //body가 있다면 그안에는 bestSellerDto가 들어있을것
                        Log.d(TAG,it.toString())

                        it.books.forEach{ book->
                            Log.d(TAG,book.toString())
                        }
                    }
                }
            })
    }
}

