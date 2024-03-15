package com.example
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import java.sql.DriverManager

@Controller("/")
class Controller {

    @Inject
    val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"

    private val connection = DriverManager.getConnection(jdbcUrl, "postgres", "postgres")

    @Get("/cities")
    fun getAllCities(): String {

        val query = connection.prepareStatement("SELECT * FROM citydetails")

        val result = query.executeQuery()


        val users = mutableListOf<CityEntity>()

        while(result.next()){

            val city = result.getString("city")

            val pincode = result.getInt("pincode")

            users.add(CityEntity(city, pincode))
        }

        return users.toString()
    }

    @Get("/users")
    fun helloWorld(): String {

        val query = connection.prepareStatement("SELECT * FROM userdata")

        val result = query.executeQuery()

        val users = mutableListOf<CityEntity>()

        while(result.next()){

            val city = result.getString("city")

            val pincode = result.getInt("pincode")

            users.add(CityEntity(city, pincode))
        }

        return users.toString()
    }
}

@Controller("/add")
class AddController{
    @Inject
    val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"

    private val connection = DriverManager.getConnection(jdbcUrl, "postgres", "postgres")

    @Post("/user")
    fun addUser(@Body user : UserEntity): String {

        connection.createStatement().executeUpdate("INSERT INTO userdata VALUES (${user.id}, '${user.name}', '${user.city}', '${user.pincode}'); ")

        return "Data Added Success !!!"
    }
}