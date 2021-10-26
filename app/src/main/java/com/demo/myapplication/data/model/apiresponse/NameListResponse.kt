package com.demo.myapplication.data.model.apiresponse

import com.demo.myapplication.data.model.base.BaseResponse
import com.demo.myapplication.data.model.pojo.NamePojo
import com.demo.myapplication.data.remote.ApiClient
import com.demo.myapplication.utils.NetworkResponseCallback
import com.demo.myapplication.utils.Parser
import com.google.gson.annotations.SerializedName
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NameListResponse : BaseResponse<NameListResponse, String, Any>() {

    @SerializedName("message")
    lateinit var message: String

    @SerializedName("data")
    lateinit var data: List<NamePojo>

    override fun doNetworkRequest(
        requestParam: HashMap<String, Any>,
        vararg: Any,
        networkResponseCallbackFeed: NetworkResponseCallback<NameListResponse>
    ): Disposable {

        return ApiClient.getapi().nameList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                networkResponseCallbackFeed.onResponseServer(it)
            },
                { throwable ->
                    Parser.onErrorFromServer(throwable, networkResponseCallbackFeed)
                })
    }
}
