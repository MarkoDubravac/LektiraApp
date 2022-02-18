package com.example.projektni_

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.projektni_.model.Lektiras
import com.example.projektni_.model.LektirasItem

class Lektire : AppCompatActivity() {

    private val dataList: MutableList<LektirasItem> = mutableListOf()
    private val searchDataList: MutableList<LektirasItem> = mutableListOf()
    private lateinit var myAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lektire)

        myAdapter = RecyclerAdapter(searchDataList)

        val myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = myAdapter

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://api.jsonbin.io/b/61d5cee12362237a3a32af44/5")
            .build()
            .getAsObject(Lektiras::class.java, object : ParsedRequestListener<Lektiras> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(response: Lektiras) {
                    dataList.addAll(response)
                    searchDataList.addAll(dataList)
                    myAdapter.notifyDataSetChanged()
                }
                override fun onError(anError: ANError?) {
                }
            }
            )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        val item=menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val toast = Toast.makeText(applicationContext, "Hej! Klikni na lektiru!", Toast.LENGTH_LONG)
                toast.show()
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                searchDataList.clear()
                val searchText = newText!!.lowercase()
                if(searchText.isNotEmpty()){
                    dataList.forEach{
                        if(it.title.lowercase().contains(searchText) || it.author.lowercase().contains(searchText) || it.place.lowercase().contains(searchText)){
                            searchDataList.add(it)
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                }
                else{
                    searchDataList.clear()
                    searchDataList.addAll(dataList)
                    myAdapter.notifyDataSetChanged()
                    if(this.onBackPressed()){
                        searchDataList.clear()
                        searchDataList.addAll(dataList)
                        myAdapter.notifyDataSetChanged()
                    }
                }
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
    private fun SearchView.OnQueryTextListener.onBackPressed(): Boolean {
        return true
    }

}


