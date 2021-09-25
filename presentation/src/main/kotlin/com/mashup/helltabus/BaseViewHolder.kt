/*
 * Created by Leo on 2021. 09. 26 ..
 */
package com.mashup.helltabus

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<out B : ViewDataBinding, in D>(
    parent: ViewGroup,
    @LayoutRes layoutRes: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(layoutRes, parent, false)
) {
    
    protected val context: Context
        get() = itemView.context
    
    protected val binding: B
        get() = DataBindingUtil.bind(itemView)!!
    
    abstract fun bind(data: D)
    
    open fun recycled() {
        /* explicitly empty */
    }
}
