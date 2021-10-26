package com.demo.myapplication.data.model.base

import com.demo.myapplication.utils.NetworkResponseCallback
import com.google.gson.annotations.SerializedName
import io.reactivex.disposables.Disposable
import java.util.HashMap

abstract class BaseResponse<T, K, V> {

    @SerializedName("status")
    var isSuccess: String = ""

    @SerializedName("error")
    var errorBean:ErrorBean? = null

    abstract fun doNetworkRequest(requestParam: HashMap<K, V>, vararg : Any, networkResponseCallback: NetworkResponseCallback<T>): Disposable

}