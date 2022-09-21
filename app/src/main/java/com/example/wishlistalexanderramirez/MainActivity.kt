package com.example.wishlistalexanderramirez

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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
    lateinit var wishList: MutableList<WishList>
    lateinit var nameET: EditText
    lateinit var priceET: EditText
    lateinit var wSiteET: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishButton = findViewById<Button>(R.id.wlistButton)
        wishList = mutableListOf()
        val nameET = findViewById<EditText>(R.id.nameTV)
        val priceET = findViewById<EditText>(R.id.priceTV)
        val wSiteET = findViewById<EditText>(R.id.emailTV)
        wListRV = findViewById(R.id.wListRV)
        adapter = wListAdapter(context = this, wishList)
        wListRV.adapter = adapter
        wListRV.layoutManager = LinearLayoutManager(this)



        wishButton.setOnClickListener() {
            val newWish = WishList(nameET.text.toString(), priceET.text.toString(), wSiteET.text.toString())

            wishList.add(newWish)
            adapter.notifyDataSetChanged()

            nameET.getText().clear();
            priceET.getText().clear()
            wSiteET.getText().clear()
            closeKeyBoard(nameET)
            wListRV.smoothScrollToPosition(wishList.lastIndex)
        }



    }
    private fun closeKeyBoard(view: View) {
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}