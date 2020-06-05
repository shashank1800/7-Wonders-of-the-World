package com.shashankbhat.sevenwondersofworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeRecyclerView = findViewById<RecyclerView>(R.id.home_recycler_view)
        homeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val rVWorkAdapter = MainRecyclerAdapter()
        homeRecyclerView.adapter = rVWorkAdapter

        GlobalScope.launch {

        }


    }
}
