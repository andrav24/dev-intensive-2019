package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullname: String?): Pair<String?, String?> {
        val parts :List<String>? = fullname?.split(" ")
        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty { null }

        //return Pair(firstName, lastName)
        return firstName to lastName        // инфкликсная запись "return Pair(firstName, lastName)"
    }

    fun transliteration(payload: String, divider:String = " "): String {
        TODO("not implemented")
    }
}