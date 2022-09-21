package com.example.wishlistalexanderramirez

import android.widget.EditText
import java.util.ArrayList

class wishFetcher {
    companion object {

        var itemNames: MutableList<String> = mutableListOf()
        var itemPrices: MutableList<String> = mutableListOf()
        var itemWSites : MutableList<String> = mutableListOf()
        fun getWishs(): MutableList<WishList> {
            var wishs : MutableList<WishList> = ArrayList()
            for (i in 0..20) {
                val wishes = WishList(itemNames[i], itemPrices[i], itemWSites[i])
                wishs.add(wishes)
            }
            return wishs
        }
    }

}