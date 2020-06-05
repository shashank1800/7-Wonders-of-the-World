package com.shashankbhat.sevenwondersofworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shashankbhat.sevenwondersofworld.api.API
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    var url = "https://raw.githubusercontent.com/shashank1800/7-Wonders-of-the-World/master/api/"
    var retrofit: Retrofit? = null
    private var wonders: ArrayList<Wonders> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeRecyclerView = findViewById<RecyclerView>(R.id.home_recycler_view)
        homeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val rVWorkAdapter = MainRecyclerAdapter()
        homeRecyclerView.adapter = rVWorkAdapter

        GlobalScope.launch {
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .build()

            val api = retrofit!!.create(API::class.java)

            val repos: Call<ResponseBody?>? = api.getData()
            repos!!.enqueue(object : Callback<ResponseBody?> {

                override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                    if (response.isSuccessful) {
                        try {
                            val json = JSONArray(response.body()!!.string())
                            println(json)

                            for( index in 0 until json.length()){
                                val wonder = json.getJSONObject(index)
                                val name = wonder.getString("name")
                                val country = wonder.getString("country")
                                val desc = wonder.getString("desc")
                                val image = wonder.getString("image")

                                println(name+country+desc+image)

                                wonders.add(Wonders(name,country,desc,image))
                            }
                            rVWorkAdapter.setWondersList(wonders)

                        } catch (e: Exception) { }
                    }

                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
        }
    }
}
