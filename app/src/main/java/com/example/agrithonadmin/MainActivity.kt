package com.example.agrithonadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val url = "https://agrithon-admin-api.loca.lt"
//    var response = PredictData
//    var response = AdminResponse("", responsePred)

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<RVAdapter.ViewHolder>
    private lateinit var list: ArrayList<PredictData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirestoreClass().getData(this@MainActivity)

        layoutManager = LinearLayoutManager(this@MainActivity)
        rv_main.layoutManager = layoutManager


    }


    fun getData(dataList: ArrayList<PredictData>) {
        list = dataList
        adapter = RVAdapter(this@MainActivity, list)
        rv_main.adapter = adapter
    }


//    private fun getData() {
//        val service = APIService.create(url)
//
//        CoroutineScope(Dispatchers.Main).launch {
//            val call: Call<AdminResponse> = service.getAdminData()
//            call.enqueue(object : retrofit2.Callback<AdminResponse> {
//
//                override fun onResponse(call: Call<AdminResponse>, response: Response<AdminResponse>) {
//                    val response = response.body()
//                    Log.e("Sample", response.toString())
//                }
//
//                override fun onFailure(call: Call<AdminResponse>, t: Throwable) {
//                    Log.e("Sample", t.message.toString())
//                }
//            })
//        }
//    }
//
//    fun JsonArray.toArrayList(): ArrayList<String> {
//        val list = arrayListOf<String>()
//        for (i in 0 until this.size()) {
//            list.add(this.get(i).asString)
//        }
//
//        return list
//    }

//    private fun getData() {
//        val destinationService  = ServiceBuilder.buildService(APIService::class.java)
//        val requestCall =destinationService.getAdminData()
//        //make network call asynchronously
//        requestCall.enqueue(object : Callback<List<PredictData>> {
//            override fun onResponse(call: Call<List<PredictData>>, response: Response<List<PredictData>>) {
//                Log.d("Response", "onResponse: ${response.body()}")
//                if (response.isSuccessful){
//                    val new_list  = response.body()!!
//                    Log.e("list", new_list.toString())
//                    rv_main.apply {
//                        setHasFixedSize(true)
//                        layoutManager = LinearLayoutManager(this@MainActivity)
//                        rv_main.layoutManager = layoutManager
//
//                        list = response.body() as ArrayList<PredictData>
//                        adapter = RVAdapter(this@MainActivity, list)
//                        rv_main.adapter = adapter
//                    }
//                }else{
//                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
//                }
//            }
//            override fun onFailure(call: Call<List<PredictData>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}