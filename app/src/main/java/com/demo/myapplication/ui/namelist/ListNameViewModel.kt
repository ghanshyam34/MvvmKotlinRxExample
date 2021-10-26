package com.demo.myapplication.ui.namelist

import androidx.lifecycle.MutableLiveData
import com.demo.myapplication.MainApplication
import com.demo.myapplication.data.model.apiresponse.NameListResponse
import com.demo.myapplication.data.model.pojo.NamePojo
import com.demo.myapplication.ui.base.BaseViewModel
import com.demo.myapplication.utils.NetworkResponseCallback

class ListNameViewModel : BaseViewModel<ListNameNavigator>(){
    var listNameResponse = MutableLiveData<List<NamePojo>>()

    fun callNameListApi() {

        var requestParam: HashMap<String, Any> = HashMap();
        navigator!!.showProgressDialog()
        disposable.add(
                NameListResponse()
                        .doNetworkRequest(requestParam,MainApplication,
                                object : NetworkResponseCallback<NameListResponse> {

                                    override fun onResponseServer(response: NameListResponse) {
                                        navigator!!.hideProgressDialog()
                                        if (response.isSuccess.equals("success")!!) {
                                            listNameResponse.value = response.data
//                                            navigator!!.showList(response)
                                        } else {
                                            onErrorResponse(response.message!!)
                                        }

                                    }

                                    override fun onAppVersionUpdate(msg: String) {
                                        navigator!!.hideProgressDialog()
                                    }

                                    override fun onErrorResponse(msg: String) {
                                        navigator!!.hideProgressDialog()
                                    }

                                    override fun onSessionExpire(msg: String) {
                                        navigator!!.hideProgressDialog()
                                    }
                                })
        )
    }
}