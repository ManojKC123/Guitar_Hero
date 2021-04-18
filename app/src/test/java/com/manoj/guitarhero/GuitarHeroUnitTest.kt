package com.manoj.guitarhero

import com.manoj.guitarhero.api.ServiceBuilder.token
import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.repository.BlogRepository
import com.manoj.guitarhero.repository.ProductRepository
import com.manoj.guitarhero.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GuitarHeroUnitTest {
    private lateinit var userRepository: UserRepository
    private lateinit var productRepository: ProductRepository
    private lateinit var blogRepository: BlogRepository

    // -----------------------------User Testing-----------------------------
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.checkUser("usert@gmail.com", "u")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun registerUser() = runBlocking {
        val user =
                User(firstname = "test", lastname = "test", phone = "zxxcxcx",
                        address = "testpassword", email = "user1@gmail.com", password = "u")
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun getUser() = runBlocking {
        userRepository = UserRepository()
        token ="Bearer " + userRepository.checkUser("user@gmail.com","u").token
        val expectedResult = true
        val actualResult = userRepository.getUser().success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun getAllProducts() = runBlocking {
        userRepository=UserRepository()
        productRepository = ProductRepository()
        token ="Bearer " + userRepository.checkUser("user@gmail.com","u")
        val expectedResult = true
        val actualResult = productRepository.getAllProducts().success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun getAllBlogs() = runBlocking {
        blogRepository=BlogRepository()
        userRepository = UserRepository()
        token ="Bearer " + userRepository.checkUser("user@gmail.com","u")
        val expectedResult = true
        val actualResult = blogRepository.getAllBlogs().success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun update() = runBlocking {
        val user = User(address = "Dhaka")
        userRepository = UserRepository()
        token ="Bearer " + userRepository.checkUser("user1@gmail.com","u")
        val expectedResult = true
        val actualResult = userRepository.updateUser(user).success
        Assert.assertEquals(expectedResult, actualResult)
    }


}