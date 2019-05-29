package com.leocoesta.listapaginada.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.leocoesta.listapaginada.R

class CustomAdapter(context: Context, private var listaNumeros: MutableList<Int>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    private val VIEW_TYPE_ITEM: Int = 0
    private val VIEW_TYPE_LOADING: Int = 1
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    open inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class DadosViewHolder(itemView: View) : CustomViewHolder(itemView) {
        val numeroText: TextView = itemView.findViewById(R.id.numero_text)
    }

    inner class ProgressViewHolder(itemView: View) : CustomViewHolder(itemView) {
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView: View

        return if (viewType == VIEW_TYPE_ITEM) {
            itemView = inflater.inflate(R.layout.item_lista, parent, false)
            DadosViewHolder(itemView)
        }
        else {
            itemView = inflater.inflate(R.layout.linha_carregando, parent, false)
            ProgressViewHolder(itemView)
        }

    }

    override fun getItemCount() = listaNumeros.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        if (holder is DadosViewHolder)
            holder.numeroText.text = listaNumeros[position].toString()

    }

    fun addNullData() {
        listaNumeros.add(-1)
        notifyItemInserted(listaNumeros.size - 1)
    }

    fun removeNull() {
        listaNumeros.remove(listaNumeros.size - 1)
        notifyItemRemoved(listaNumeros.size)
    }

    fun addData(integersList: MutableList<Int>) {
        listaNumeros.addAll(integersList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) =
        if (listaNumeros[position] > -1)
            VIEW_TYPE_ITEM
        else
            VIEW_TYPE_LOADING

}