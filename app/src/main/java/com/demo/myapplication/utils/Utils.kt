package com.demo.myapplication.utils

object Utils {
    fun uppercaseFirstLettersuser(str: String): String? {
        var prevWasWhiteSp = true
        val chars = str.toCharArray()
        for (i in chars.indices) {
            if (Character.isLetter(chars[i])) {
                if (prevWasWhiteSp) {
                    chars[i] = Character.toUpperCase(chars[i])
                }
                prevWasWhiteSp = false
            } else {
                prevWasWhiteSp = Character.isWhitespace(chars[i])
            }
        }
        return String(chars)
    }
}