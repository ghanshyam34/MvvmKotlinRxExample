package com.demo.myapplication.data.model.pojo

import com.demo.myapplication.utils.Utils
import com.google.gson.annotations.SerializedName

data class NamePojo(@SerializedName("employee_name") var name: String) {

    fun getCapitalLetterName(): String {
        return Utils.uppercaseFirstLettersuser(name)!!
    }
}
