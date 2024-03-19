package com.example
import com.example.Structure.CityStructure
import com.example.Structure.UserEntity
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

@Controller("/")
class AddController{
    @Inject
    val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"
    private val dbManager = DBManager(jdbcUrl)

    @Post("/add/user")
    fun addUser(@Body user : UserEntity): String {

        dbManager.addUser(user.id, user.name, user.city, user.pincode)

        return "Data Added Success !!!"
    }

    @Put("/update/city")
    fun upDateUser(@Body cityS : CityStructure) : String{
        dbManager.editCity(cityS.newName, cityS.pincode)
        return "UPDATED CITY NAME"
    }
}
