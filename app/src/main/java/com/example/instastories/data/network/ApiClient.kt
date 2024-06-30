package com.example.instastories.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    fun getClient(context: Context): Retrofit {
        if (retrofit == null) {
            // Set up cache
            val cacheSize = 10 * 1024 * 1024 // 10 MB
            val cache = Cache(context.getCacheDir(), cacheSize.toLong())

            val okHttpClient = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (hasNetwork(context)!!)
                        request.newBuilder().header("Cache-Control", "public, max-age=" + 60)
                            .build()
                    else
                        request.newBuilder().header(
                            "Cache-Control",
                            "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 1
                        ).build()
                    chain.proceed(request)
                }
                .build()

            // Build Retrofit instance
            retrofit = Retrofit.Builder()
                .baseUrl("https://us-central1-insta-stories-firebase.cloudfunctions.net/app/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}

