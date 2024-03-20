package com.example

import io.micronaut.data.model.query.QueryModel.In
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement


class DBManager(private val jdbcUrl: String) {
    var dbInstance = getDBInstance()

    init {
        refreshDB()
    }

    private fun refreshDB() {
        executeQuery("TRUNCATE TABLE userdata;")
        executeQuery("TRUNCATE TABLE citydetails;")
        executeQuery("INSERT INTO userdata(id, name, city, pincode) VALUES (1, 'Vyankatesh', 'Nashik', 424203), (2, 'Ajinkya', 'Pune', 424201), (4, 'Rajshree', 'Nagpur', 424202);")
        executeQuery("INSERT INTO citydetails(pincode, city) VALUES (424203, 'Nashik'), (424201, 'Pune'), (424202, 'Nagpur');")
    }

    private fun getDBInstance(): Connection {
        return DriverManager.getConnection(jdbcUrl, "postgres", "postgres")
    }

    private fun executeQuery(query: String): Int {
        return dbInstance.createStatement().executeUpdate(query)
    }

    fun addUser(id: Int, name: String, city: String, pincode: Int): Boolean {
        val query = "INSERT INTO userdata VALUES ($id, '$name', '$city', $pincode)"
        val response = executeQuery(query)
        return response == 1
    }

    fun editCity(newName: String, pincode: Int): Boolean {
        val response1 = executeQuery("UPDATE citydetails SET city = '$newName' WHERE pincode = $pincode")
        val response2 = executeQuery("UPDATE userdata SET city = '${newName}' WHERE pincode = $pincode")
        return response1 != 0 && response2 != 0
    }

}
