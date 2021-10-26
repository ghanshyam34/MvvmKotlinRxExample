package com.demo.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Patterns
import com.demo.myapplication.MainApplication

/**
 * Created by Ghanshyam.
 */
object Validation {
    fun isValidEmail(target: String?): Boolean {
        return if (target == null) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    /**
     * this method checks the string is null or empty or not
     *
     * @param str
     * @return`
     */
    fun isStringNullOrBlank(str: String?): Boolean {
        try {
            if (str == null) {
                return true
            } else if (str == "null" || str == "" || str != null && str.isEmpty() || str != null && str.length <= 0 || str.equals(
                    "null",
                    ignoreCase = true
                )
            ) {
                return true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    /**
     * this checks the network connectivity status
     *
     * @return
     */
    fun isNetworkConnected(): Boolean {
        try {
            val connectivityManager =
                MainApplication.instance!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            val mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            val bluetooth = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH)
            val wimax = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIMAX)
            if (wifi == null && mobile == null && bluetooth == null && wimax == null) {
                return false
            }
            if (wifi != null && wifi.isConnected) {
                return true
            }
            if (mobile != null && mobile.isConnected) {
                return true
            }
            if (bluetooth != null && bluetooth.isConnected) {
                return true
            }
            if (wimax != null && wimax.isConnected) {
                return true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}