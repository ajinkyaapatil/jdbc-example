package com.example

import java.sql.Connection
import java.sql.DriverManager

class DBManager(private val jdbcUrl : String) {

    var dbInstance = getDBInstance()

    private fun getDBInstance(): Connection {
        return DriverManager.getConnection(jdbcUrl, "postgres", "postgres")
    }

    fun execute(query : String){
        dbInstance.createStatement().executeUpdate(query)
    }

}
