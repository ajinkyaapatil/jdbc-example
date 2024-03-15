package com.example
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject
import java.sql.DriverManager

@Controller("/")
class AddController{
    @Inject
    val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"
    private val connection = DriverManager.getConnection(jdbcUrl, "postgres", "postgres")

    @Post("/add/user")
    fun addUser(@Body user : UserEntity): String {

        connection.createStatement().executeUpdate("INSERT INTO userdata VALUES (${user.id}, '${user.name}', '${user.city}', '${user.pincode}'); ")

        return "Data Added Success !!!"
    }

    @Put("/update/city")
    fun upDateUser(@Body cityS : CityStructure) : String{
        connection.createStatement().executeUpdate("UPDATE citydetails SET city = '${cityS.newName}' WHERE pincode = ${cityS.pincode}")

        return "UPDATED CITY NAME"
    }
}
