package com.example.Structure

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable.Deserializable
data class CityStructure (val newName : String, val pincode : Int)