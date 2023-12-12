package com.example.lunatiket.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lunatiket.data.MainAdapter
import com.example.lunatiket.data.remote.ApiService
import com.example.lunatiket.data.remote.PesawatItem
import com.example.lunatiket.databinding.ActivityFlightBinding
import com.example.lunatiket.utils.Constant.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlightBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        getUsersData()

    }
    private fun getUsersData(){
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getLanguages().enqueue(object: retrofit2.Callback<List<PesawatItem>> {
            override fun onResponse(
                call: retrofit2.Call<List<PesawatItem>>,
                response: retrofit2.Response<List<PesawatItem>>
            ){
                if (response.isSuccessful){
                    val data = response.body()!!
                    viewAdapter = MainAdapter(baseContext, data)
                    binding.listRv.apply{
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<PesawatItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}