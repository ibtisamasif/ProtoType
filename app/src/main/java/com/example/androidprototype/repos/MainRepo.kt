package com.example.androidprototype.repos

import com.example.androidprototype.core.PrototypePrefManager

class MainRepo(private val prefManager: PrototypePrefManager) {
    fun storeData(data: String) {
        val storedData = arrayListOf<String>()
        storedData.addAll(prefManager.persistedData)
        storedData.add(data)
        prefManager.persistedData = storedData
    }

    suspend fun fetchData() = prefManager.persistedData
}