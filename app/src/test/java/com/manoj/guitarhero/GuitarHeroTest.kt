package com.manoj.guitarhero

import com.manoj.guitarhero.entity.User
import com.manoj.guitarhero.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GuitarHeroTest {
    private lateinit var userRepository: UserRepository
    // -----------------------------User Testing-----------------------------
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.checkUser("s@gmail.com", "s")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

//    @Test
//    fun registerUser() = runBlocking {
//        val user =
//                User(fname = "test", lname = "test", username = "zxxcxcx", password = "testpassword")
//        userRepository = UserRepository()
//        val response = userRepository.registerUser(user)
//        val expectedResult = true
//        val actualResult = response.success
//        Assert.assertEquals(expectedResult, actualResult)
//    }
//    // -----------------------------Student Testing-----------------------------
//    @Test
//    fun addStudent() = runBlocking {
//        userRepository = UserRepository()
//        studentRepository = StudentRepository()
//        val student =
//                Student(fullname = "fullName", age = 33, gender = "gender", address = "address")
//        ServiceBuilder.token ="Bearer " + userRepository.checkUser("kiran","kiran123").token
//        val expectedResult = true
//        val actualResult = studentRepository.insertStudent(student).success
//        Assert.assertEquals(expectedResult, actualResult)
//    }
}