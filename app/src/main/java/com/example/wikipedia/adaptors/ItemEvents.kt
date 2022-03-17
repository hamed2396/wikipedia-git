package com.example.wikipedia.adaptors

import com.example.wikipedia.dataClass.ItemPost

interface ItemEvents {
    fun onItemClicked(itemPost: ItemPost)
}