package com.example.wishlistalexanderramirez

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import wListAdapter


class MainActivity : AppCompatActivity() {

    lateinit var wListRV: RecyclerView
    lateinit var adapter: wListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishButton = findViewById<Button>(R.id.wlistButton)
        val wishList = mutableListOf<WishList>()
        val itemName = findViewById<EditText>(R.id.nameTV).text.toString()
        val itemPrice = findViewById<EditText>(R.id.priceTV).text.toString()
        val itemWSite = findViewById<EditText>(R.id.emailTV).text.toString()
        wListRV = findViewById(R.id.wListRV)
        adapter = wListAdapter(context = this, wishList)
        wListRV.adapter = adapter
        wListRV.layoutManager = LinearLayoutManager(this)



        wishButton.setOnClickListener() {
            wishList.add(WishList(itemName, itemPrice, itemWSite))
            adapter.notifyItemInserted(wishList.size - 1)
        }

    }
}