package com.demo.myapplication.ui.namelist

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.myapplication.BR
import com.demo.myapplication.R
import com.demo.myapplication.data.local.SharedPreferenceManager
import com.demo.myapplication.data.model.apiresponse.NameListResponse
import com.demo.myapplication.data.model.pojo.NamePojo
import com.demo.myapplication.databinding.MainListBinding
import com.demo.myapplication.ui.base.BaseActivity
import com.demo.myapplication.ui.namelist.adapter.NameListAdapter

class NamesListActivity : BaseActivity<MainListBinding, ListNameViewModel>(),
    ListNameNavigator {
    override val bindingVariable: Int get() = BR.nameVM
    override val layoutId: Int get() = R.layout.main_list
    override val viewModel: ListNameViewModel = ListNameViewModel()

    private var listNames: ArrayList<NamePojo>? = null
    private var adapter: NameListAdapter? = null
    var mLayoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.navigator = this
        setList()
    }

    private fun setList() {
        mLayoutManager = LinearLayoutManager(this)
        viewDataBinding!!.listRecycler!!.layoutManager = mLayoutManager
        viewModel.listNameResponse.observe(this, listNameResponseObserver);
        callApi()
    }

    fun callApi(){
        var list = SharedPreferenceManager.getInstance(this).getList()
        if(list == null || list.isEmpty()) {
            viewModel.callNameListApi()
        }else{
            viewModel.listNameResponse.value = list
        }
    }

    var listNameResponseObserver : Observer<List<NamePojo>> = object :
        Observer<List<NamePojo>> {
        override fun onChanged(response: List<NamePojo>?) {
            listNames = response as ArrayList<NamePojo>?
            SharedPreferenceManager.getInstance(this@NamesListActivity).setList(SharedPreferenceManager.FILE_KEY,listNames)
            setAdapter()
        }
    }

    override fun onBackClick() {
        finish()
    }

    fun setAdapter() {
        adapter = NameListAdapter(this,listNames)
        viewDataBinding!!.listRecycler!!.setAdapter(adapter)
    }

    override fun showProgressDialog() {
        showProgress()
    }

    override fun hideProgressDialog() {
        hideProgress()
    }

    override fun showList(response: NameListResponse) {

    }
}