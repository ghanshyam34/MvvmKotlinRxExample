package com.demo.myapplication.data.model.base

import com.google.gson.annotations.SerializedName

data class ErrorBean(
    @SerializedName("message")
    val message:String?)
