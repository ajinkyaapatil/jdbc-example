package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable.Deserializable

@Introspected
@Deserializable
data class UserEntity(val id : Int, val name : String, val city : String, val pincode : Int)