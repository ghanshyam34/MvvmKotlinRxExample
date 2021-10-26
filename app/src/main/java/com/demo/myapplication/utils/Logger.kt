package com.demo.myapplication.utils

import android.util.Log

/**
 * Created by Ghanshyam.
 */
object Logger {
    fun d(tag: String?, msg: String?) {
        Log.d(tag, msg!!)
    }

    fun i(tag: String?, msg: String?) {
        Log.i(tag, msg!!)
    }

    fun w(tag: String?, msg: String?) {
        Log.w(tag, msg!!)
    }

    fun e(tag: String?, msg: String?) {
        Log.e(tag, msg!!)
    }

    fun v(tag: String?, msg: String?) {
        Log.v(tag, msg!!)
    }

    fun e(tag: String?, msg: String?, tr: Throwable?) {
        Log.e(tag, msg, tr)
    }

    fun w(tag: String?, msg: String?, tr: Throwable?) {
        Log.w(tag, msg, tr)
    }

    fun d(tag: String?, msg: String?, tr: Throwable?) {
        Log.d(tag, msg, tr)
    }
}