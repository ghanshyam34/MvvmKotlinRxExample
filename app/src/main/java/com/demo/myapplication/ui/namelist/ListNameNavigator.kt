package com.demo.myapplication.ui.namelist

import com.demo.myapplication.data.model.apiresponse.NameListResponse

interface ListNameNavigator {
    fun showProgressDialog()
    fun hideProgressDialog()
    fun showList(response: NameListResponse)
    fun onBackClick()
}