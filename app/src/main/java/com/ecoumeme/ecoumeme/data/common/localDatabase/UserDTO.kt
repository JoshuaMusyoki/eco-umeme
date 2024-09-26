package com.ecoumeme.ecoumeme.data.common.localDatabase

import com.ecoumeme.ecoumeme.domain.User
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

class UserDTO: RealmObject {
    @PrimaryKey
    var _id: ObjectId = BsonObjectId()
    @Index
    var name: String = ""
    var phone: String = ""
    var email: String = ""
    var password: String = ""

    fun toUser(): User {
        return User(
            name = name,
            phone = phone,
            email = email,
            password = password,
        )
    }
    companion object{
        fun User.toUserDTO() = UserDTO().apply {
            name = this@toUserDTO.name
            phone = this@toUserDTO.phone
            email = this@toUserDTO.email
            password = this@toUserDTO.password
        }
    }
}