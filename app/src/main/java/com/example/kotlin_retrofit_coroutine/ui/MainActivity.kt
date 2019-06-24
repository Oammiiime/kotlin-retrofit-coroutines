package com.example.kotlin_retrofit_coroutine.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_retrofit_coroutine.R
import com.example.kotlin_retrofit_coroutine.model.Data
import com.example.kotlin_retrofit_coroutine.model.DataModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() , LifecycleOwner , CoroutineScope {

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Main

    private val mMainViewModel: MainViewModel by viewModel()

    private var exploreAdapter: MainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mJob = Job()

        recyclerView.layoutManager =  LinearLayoutManager(this)
        recyclerView.adapter = exploreAdapter

        launch{
           val dataModel = mMainViewModel.getData()
            updateUI(dataModel)
        }
    }

    fun updateUI(dataModel : DataModel){
        exploreAdapter.submitList(dataModel.data)
    }

    override fun onDestroy() {
        super.onDestroy()

        mJob.cancel()
    }
}
