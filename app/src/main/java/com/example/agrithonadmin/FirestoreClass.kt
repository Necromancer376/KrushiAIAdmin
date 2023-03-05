package com.example.agrithonadmin

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreClass {
    private val db = FirebaseFirestore.getInstance()

    fun getData(activity: MainActivity) {
        db.collection("predictions")
            .get()
            .addOnSuccessListener { document ->
                val dataList = ArrayList<PredictData>()

                for(i in document.documents) {
                    val data = i.toObject(PredictData::class.java)
                    dataList.add(data!!)
                }

                activity.getData(dataList)
            }
            .addOnFailureListener {
                Log.e("failure", it.message.toString())
            }
    }

}