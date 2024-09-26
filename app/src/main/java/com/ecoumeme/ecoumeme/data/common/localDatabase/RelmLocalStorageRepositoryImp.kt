package com.ecoumeme.ecoumeme.data.common.localDatabase

import com.ecoumeme.ecoumeme.data.common.localDatabase.UserDTO.Companion.toUserDTO
import com.ecoumeme.ecoumeme.domain.FailedLogin
import com.ecoumeme.ecoumeme.domain.LoginResponse
import com.ecoumeme.ecoumeme.domain.SuccessLogin
import com.ecoumeme.ecoumeme.domain.User
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

class RealmLocalStorageRepositoryImp(
    private val realm: Realm
): LocalStorageRepository {
    /*override suspend fun getUserDetails(userna): User? {
    }*/

    override suspend fun saveUserDetails(user: User) {
        realm.write {
           val userItem = user.toUserDTO()
            copyToRealm(userItem)
        }
    }

    override suspend fun login(username: String, password: String): LoginResponse {
        val user = realm
            .query<UserDTO>(
                "name == $0",
                username
            )
            .first().find()?.toUser()

        return user?.let {
            if(it.password == password){
                SuccessLogin(user = user)
            } else {
                FailedLogin
            }
        } ?: FailedLogin
    }

}