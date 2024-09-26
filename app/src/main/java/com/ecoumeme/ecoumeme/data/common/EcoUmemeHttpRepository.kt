package com.ecoumeme.ecoumeme.data.common

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

class EcoUmemeHttpRepository(
    private val httpClient: HttpClient
): EcoUmemeRepository {
    override suspend fun postUserDetails(/*user: User, */) {
        val response = try {
            httpClient.post("http://127.0.0.1:5000/eusers/create"){
                //parameter("count", count)
                //body =
            }
        } catch (e: UnresolvedAddressException){
            //return Result.ResultError(NetworkError.NO_INTERNET)
        } catch (e: SerializationException){
            //return Result.ResultError(NetworkError.SERIALIZATION)
        }
    }

    override suspend fun getUserDetails() {
        val response = try {
            httpClient.get("https://orionbackend-1.onrender.com/"){
                //parameter("count", count)
            }
        } catch (e: UnresolvedAddressException){
            //return Result.ResultError(NetworkError.NO_INTERNET)
        } catch (e: SerializationException){
            //return Result.ResultError(NetworkError.SERIALIZATION)
        }
    }

}