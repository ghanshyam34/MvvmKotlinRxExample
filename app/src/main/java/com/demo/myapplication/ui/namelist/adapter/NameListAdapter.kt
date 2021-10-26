package com.demo.myapplication.ui.namelist.adapter

import android.app.Activity
import android.view.ViewGroup
import com.demo.myapplication.BR
import com.demo.myapplication.R
import com.demo.myapplication.data.model.pojo.NamePojo
import com.demo.myapplication.databinding.RowNameListItemBinding
import com.demo.myapplication.ui.base.BaseRecyclerAdapter

class NameListAdapter(
    private val context: Activity,
    private var arrayList: ArrayList<NamePojo>?
) :
    BaseRecyclerAdapter<RowNameListItemBinding, Any, NameListAdapter.NameListViewHolder>() {

    override fun onCreateViewHolder(
        viewDataBinding: RowNameListItemBinding,
        parent: ViewGroup,
        viewType: Int
    ): NameListViewHolder {
        return NameListViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: NameListViewHolder, position: Int, type: Int) {
        holder.bindToDataVM(holder.bindingVariable, holder.viewModel)
    }


    override fun getLayoutId(viewType: Int): Int {
        return R.layout.row_name_list_item
    }

    override fun getItemCount(): Int {
        return arrayList!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class NameListViewHolder(mViewDataBinding: RowNameListItemBinding) :
        BaseViewHolder(mViewDataBinding) {


        override val bindingVariable: Int
            get() = BR.data
        override val viewModel: NamePojo
            get() = arrayList!!.get(getAdapterPosition())

    }
}