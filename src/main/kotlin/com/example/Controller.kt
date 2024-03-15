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
    private val dbManager = DBManager(jdbcUrl)

    @Post("/add/user")
    fun addUser(@Body user : UserEntity): String {

        dbManager.execute("INSERT INTO userdata VALUES (${user.id}, '${user.name}', '${user.city}', '${user.pincode}'); ")

        return "Data Added Success !!!"
    }

    @Put("/update/city")
    fun upDateUser(@Body cityS : CityStructure) : String{
        dbManager.execute("UPDATE citydetails SET city = '${cityS.newName}' WHERE pincode = ${cityS.pincode}")
        dbManager.execute("UPDATE userdata SET city = '${cityS.newName}' WHERE pincode = ${cityS.pincode}")

        return "UPDATED CITY NAME"
    }
}
