package com.example.androidprototype.core

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class PrototypePrefManager(context: Context) {
    private var pref: SharedPreferences = context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    )

    var persistedData: List<String>
        get() = Gson().fromJson(pref.getString(PERSISTED_DATA, "[]"), Array<String>::class.java).toList()
        set(value) = pref.edit().putString(PERSISTED_DATA, Gson().toJson(value)).apply()

    companion object {
        private const val PREF_NAME = "PrototypePrefs"
        private const val PERSISTED_DATA = "PersistedData"
    }
}