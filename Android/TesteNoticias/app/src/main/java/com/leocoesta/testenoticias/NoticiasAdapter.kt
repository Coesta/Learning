package com.leocoesta.testenoticias

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.leocoesta.testenoticias.model.NoticiasResponse

//class NoticiasAdapter : PagedListAdapter<NoticiasResponse, RecyclerView.ViewHolder>(COMPARADOR){
//
//    companion object {
//        private val COMPARADOR = object : DiffUtil.ItemCallback<NoticiasResponse>() {
//            override fun areItemsTheSame(oldItem: NoticiasResponse, newItem: NoticiasResponse): Boolean =
//                oldItem.feed. == newItem.fullName
//
//            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean =
//                oldItem == newItem
//        }
//    }
//}