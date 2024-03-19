package com.example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

@MicronautTest
class DBMangerTest {
    private val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"
    @Test
    fun `connection is Established with the Postgress Database`(){
        val dbManager = DBManager(jdbcUrl)

        assertTrue(dbManager.dbInstance.isValid(0))
    }

    @Test
    fun `user can be added in database using the id, name, city and pincode`(){
        val dbManager = DBManager(jdbcUrl)

        val response : Boolean = dbManager.addUser(50, "Kartikay", "HP", 123456)

        assertTrue(response)
    }

    
}