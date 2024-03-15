package com.example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

@MicronautTest
class ControllerTest {
    @Test
    fun `connection is Established with the Postgress Database`(){
        val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"
        val dbManager = DBManager(jdbcUrl)

        assertTrue(dbManager.dbInstance.isValid(0))
    }
}