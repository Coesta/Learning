package com.leocoesta.testenoticias

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.leocoesta.testenoticias.databinding.ItemNoticiaListaBinding
import com.leocoesta.testenoticias.model.Item

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, noticias: PagedList<Item>?) {
    val adapter = recyclerView.adapter as NoticiasAdapter
    adapter.submitList(noticias)
}

class NoticiasAdapter : PagedListAdapter<Item, NoticiasAdapter.NoticiaViewHolder>(COMPARADOR) {

    companion object {
        private val COMPARADOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.content!!.title == newItem.content!!.title

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem
        }
    }

    class NoticiaViewHolder(private val binding: ItemNoticiaListaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.item = item
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        return NoticiaViewHolder(ItemNoticiaListaBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item!!)
    }
}