package com.leocoesta.listapaginada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.leocoesta.listapaginada.adapter.CustomAdapter


class MainActivity : AppCompatActivity(), InfiniteScrollListener.OnLoadMoreListener {

    lateinit var recyclerView: RecyclerView
    lateinit var manager: LinearLayoutManager
    lateinit var infiniteScrollListener: InfiniteScrollListener
    lateinit var listaNumeros: MutableList<Int>
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        infiniteScrollListener = InfiniteScrollListener(manager, this)
        infiniteScrollListener.setLoaded()
        recyclerView.addOnScrollListener(infiniteScrollListener)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        listaNumeros = MutableList(10) {it + 1}

        customAdapter = CustomAdapter(this, listaNumeros)
        recyclerView.adapter = customAdapter
    }

    override fun onLoadMore() {
        customAdapter.addNullData()
        Handler().postDelayed({
            customAdapter.removeNull()
            val novalista = MutableList(10) {(it + 50) + 1}
            customAdapter.addData(novalista)
            infiniteScrollListener.setLoaded()
        }, 2000)
    }
}
