package com.demo.myapplication.utils




interface NetworkResponseCallback<T> {

    fun onResponseServer(`object`: T)

    fun onAppVersionUpdate(msg: String)

    fun onErrorResponse(msg: String)

    fun onSessionExpire(msg: String)

}
