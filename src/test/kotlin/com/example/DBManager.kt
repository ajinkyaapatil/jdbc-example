package com.example

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

@MicronautTest
class DBMangerTest {
    companion object {
        lateinit var dbManager: DBManager
        const val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"

        @BeforeAll
        @JvmStatic
        fun setup() {
            dbManager = DBManager(jdbcUrl)
        }
    }

    @Test
    fun `connection is Established with the Postgress Database`() {
        assertTrue(dbManager.dbInstance.isValid(0))
    }

    @Test
    fun `should return true when dbManager adds a user in database using the id, name, city and pincode`() {

        val response: Boolean = dbManager.addUser(50, "Kartikay", "HP", 123456)

        assertTrue(response)
    }

    @Test
    fun `should return true when dbManager changes the city name as per provided pincode`() {

        val response = dbManager.editCity("PCMC", 424201)

        assertTrue(response)
    }

    @Test
    fun `should return false when dbManager changes the city name when provided with pincode not present in DB`() {

        val response = dbManager.editCity("PCMC", 424252)

        assertFalse(response)
    }



}