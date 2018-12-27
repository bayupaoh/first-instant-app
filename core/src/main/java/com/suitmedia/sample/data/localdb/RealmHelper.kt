package com.suitmedia.sample.data.localdb

import io.realm.Realm
import io.realm.RealmObject
import io.realm.Sort

/**
 * Created by dodydmw19 on 7/25/18.
 */

class RealmHelper<T : RealmObject> {

    fun saveObject(data: T) {
        var realm: Realm? = null
        try {
            realm = Realm.getDefaultInstance()
            realm?.executeTransaction { r -> r.copyToRealmOrUpdate(data) }
        } finally {
            realm?.close()
        }
    }

    fun saveList(data: List<T>?) {
        var realm: Realm? = null
        try {
            realm = Realm.getDefaultInstance()
            realm?.executeTransaction { r -> r.copyToRealmOrUpdate(data) }
        } finally {
            realm?.close()
        }
    }

    fun getData(id: Int, paramName: String, data: T): T? {
        val realm: Realm = Realm.getDefaultInstance()
        val cache = realm.where(data::class.java).equalTo(paramName, id).findFirst()!!
        var validData: T? = null
        if(cache.isValid){
            validData = cache
        }
        return validData
    }

    fun getData(data: T): List<T>? {
        val realm: Realm = Realm.getDefaultInstance()
        val cache = realm.where(data::class.java).findAll()!!
        var validData: List<T>? = emptyList()
        if (cache.isValid) {
            validData = cache
        }
        return validData
    }

    fun getDataSorted(data: T): List<T>? {
        val realm: Realm = Realm.getDefaultInstance()
        val cache = realm.where(data::class.java).sort("date", Sort.DESCENDING).findAll()!!
        var validData: List<T>? = emptyList()
        if(cache.isValid){
            validData = cache
        }
        return validData
    }


    fun getSingleData(data: T): T? {
        val realm: Realm = Realm.getDefaultInstance()
        val cache = realm.where(data::class.java).findFirst()!!
        var validData: T? = null
        if(cache.isValid){
            validData = cache
        }
        return validData
    }

    fun getDataListQuery(id: Int, paramName: String, data: T): List<T> {
        val realm: Realm = Realm.getDefaultInstance()
        return realm.where(data::class.java).equalTo(paramName, id).findAll()!!
    }

    fun deleteData(data: T) {
        var realm: Realm? = null
        try {
            realm = Realm.getDefaultInstance()
            val realmResult = realm.where(data::class.java).findAll()!!
            if(realmResult.isValid) {
                realm?.executeTransaction { r -> realmResult.deleteAllFromRealm() }
            }
        } finally {
            realm?.close()
        }

    }


}