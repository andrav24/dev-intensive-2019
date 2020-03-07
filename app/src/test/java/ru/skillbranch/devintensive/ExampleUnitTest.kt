package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1", "John", "Doe")
        user.printMe()
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("Jong Yung")
        val user2 = user.copy("2", lastName = "Niang", lastVisit = Date())

        print("$user \n$user2")

    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("Jong Yung")

        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }

    @Test
    fun test_copy_without_arg_changes() {
        val user  = User.makeUser("Jong Yung")
        val user2 = user.copy()

        if (user == user2) {
            println("equals data and hash \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        } else {
            println("not equals data and hash \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }

        if (user === user2) {
            println("equals address \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        } else {
            println("not equals address \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        }

    }

    @Test
    fun test_copy_with_arg_changes() {
        val user  = User.makeUser("Jong Yung")
        val user2 = user.copy("2", lastVisit = Date())

        if (user == user2) {
            println("equals data and hash \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        } else {
            println("not equals data and hash \n ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }

        if (user === user2) {
            println("equals address \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        } else {
            println("not equals address \n ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        }
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${Date().format()}
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }
}
