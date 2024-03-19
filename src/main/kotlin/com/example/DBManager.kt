package com.example

import java.sql.Connection
import java.sql.DriverManager

class DBManager(private val jdbcUrl : String) {
    var dbInstance = getDBInstance()

    init {
        execute("TRUNCATE TABLE citydetails")
        execute("TRUNCATE TABLE userdata")
    }

    private fun getDBInstance(): Connection {
        return DriverManager.getConnection(jdbcUrl, "postgres", "postgres")
    }

    fun execute(query : String) : Int{
        return dbInstance.createStatement().executeUpdate(query)
    }

    fun addUser(id: Int, name: String, city: String, pincode: Int): Boolean {
        val response = execute("INSERT INTO userdata VALUES ($id, '$name', '$city', $pincode);")
        return response == 1
    }

}
