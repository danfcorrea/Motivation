package com.danfcorrea.motivation.services

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, string: String){
        security.edit().putString(key, string).apply()
    }

    fun getString(key: String): String{
        return security.getString(key, "") ?: ""
    }
}