package com.dubrechi.ambag.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dubrechi.ambag.CheckpointsDTO
import com.dubrechi.ambag.CoroutineFunctions
import com.dubrechi.ambag.R
import com.dubrechi.ambag.adapter.CheckpointsAdapter
import kotlinx.android.synthetic.main.fragment_checkpoints.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Checkpoints : Fragment() {

    private lateinit var checkpoints: MutableList<CheckpointsDTO>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_checkpoints, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeContainer_checkpoints.setOnRefreshListener {

            checkpoints.clear()
            rv_checkpoints.adapter?.notifyDataSetChanged()

            getCheckpointLocations()
        }

        getCheckpointLocations()
    }


    private fun getCheckpointLocations() {

        CoroutineScope(IO).launch {
            withContext(Main) {

                checkpoints = CoroutineFunctions().getCheckpoints()

                rv_checkpoints.layoutManager = LinearLayoutManager(activity)
                rv_checkpoints.adapter = CheckpointsAdapter(checkpoints)

                if (swipeContainer_checkpoints.isRefreshing) {

                    swipeContainer_checkpoints.isRefreshing = false
                }
            }
        }
    }
}