package com.demo.myapplication.data.local

import android.content.Context
import android.content.SharedPreferences
import com.demo.myapplication.MainApplication
import com.demo.myapplication.data.model.pojo.NamePojo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class SharedPreferenceManager {

  companion object {
    val STORE_FILE_NAME: String? = "STORE_FILE_NAME"
    val FILE_KEY: String? = "FILE_KEY"
    var sharedPreferences: SharedPreferences? = null
    var instance:SharedPreferenceManager? =null
    fun getInstance(context: Context): SharedPreferenceManager {
        if (instance == null) {
            sharedPreferences = context!!.getSharedPreferences(STORE_FILE_NAME, Context.MODE_PRIVATE)
            instance = SharedPreferenceManager()
            return instance as SharedPreferenceManager

        } else {
            return instance as SharedPreferenceManager
        }
      }
    }

    fun <T> setList(key: String?, list: List<T>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        set(key, json)
    }

    operator fun set(key: String?, value: String?) {
        val editor = sharedPreferences!!.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getList(): List<NamePojo> {
        var arrayItems: List<NamePojo> = ArrayList<NamePojo>()
        val serializedObject = sharedPreferences!!.getString(FILE_KEY, null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<NamePojo?>?>() {}.type
            arrayItems = gson.fromJson<List<NamePojo>>(serializedObject, type)
        }
        return arrayItems
    }
}