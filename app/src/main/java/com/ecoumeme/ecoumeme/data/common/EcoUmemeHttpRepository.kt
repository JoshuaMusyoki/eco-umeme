package com.ecoumeme.ecoumeme.data.common

import com.ecoumeme.ecoumeme.domain.UserDetails
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.append
import io.ktor.http.contentType
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

class EcoUmemeHttpRepository(
    private val httpClient: HttpClient
): EcoUmemeRepository {
    override suspend fun postUserDetails(userDetails: UserDetails): Boolean {
        val response = try {
            return true
            httpClient.post("https://orionbackend-1.onrender.com/eusers/create"){
                //parameter("count", count)
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                }
                setBody(userDetails)
            }
        } catch (e: UnresolvedAddressException){
            return false
        } catch (e: SerializationException){
            return false
        }

        return when(response.status.value){
            //Success codes
            in 200..299 -> {
                val facts = response.body<BackendResponse>()
                true
            }
            else ->{
                false
            }
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