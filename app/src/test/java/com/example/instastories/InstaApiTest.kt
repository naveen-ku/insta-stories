package com.example.instastories

import com.example.instastories.data.network.InstaApiService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaApiTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var instaApiService: InstaApiService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        instaApiService = Retrofit.Builder().baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(InstaApiService::class.java)
    }

    @org.junit.jupiter.api.Test
    suspend fun testGetUsers() {
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = instaApiService.getUsers()
        mockWebServer.takeRequest()

        Assert.assertEquals(false, response!!.isEmpty())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}