package com.demo.myapplication.utils

import com.demo.myapplication.MainApplication
import com.demo.myapplication.R

/**
 * Created by Ghanshyam.
 */
object ErrorUtils {

    fun getHtttpCodeError(statusCode: Int): String {
        var error = "" + MainApplication.instance!!.getString(R.string.failled)
        when (statusCode) {
            400 -> error = MainApplication.instance!!.getString(R.string.https_400_error)
            401 -> error = MainApplication.instance!!.getString(R.string.http_401_error)
        }
        return error
    }
}