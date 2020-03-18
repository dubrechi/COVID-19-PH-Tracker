package com.dubrechi.ambag.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dubrechi.ambag.*
import com.dubrechi.ambag.Application.Companion.admitted
import com.dubrechi.ambag.Application.Companion.died
import com.dubrechi.ambag.Application.Companion.recovered
import com.dubrechi.ambag.adapter.CasesAdapter
import kotlinx.android.synthetic.main.activity_cases.*
import kotlinx.android.synthetic.main.fragment_patients_under_investigation.*


class CasesActivity : AppCompatActivity() {

    private fun initCases(label:String) {

        var cases:MutableList<CaseDTO> = ArrayList()

        when (label) {
            getString(R.string.recovered) -> cases = recovered
            getString(R.string.admitted) -> cases = admitted
            getString(R.string.died) -> cases = died
        }

        rv_cases.layoutManager = LinearLayoutManager(this)
        rv_cases.adapter = CasesAdapter(cases)

        if (swipeContainer.isRefreshing) {
            swipeContainer.isRefreshing = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cases)

//        tv_text.text = intent.extras?.get("label").toString()

        initCases(intent.extras?.get("label").toString())
    }
}
