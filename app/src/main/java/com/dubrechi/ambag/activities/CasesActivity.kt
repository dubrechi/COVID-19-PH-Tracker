package com.dubrechi.ambag.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dubrechi.ambag.*
import com.dubrechi.ambag.Application.Companion.admitted
import com.dubrechi.ambag.Application.Companion.died
import com.dubrechi.ambag.Application.Companion.recovered
import com.dubrechi.ambag.Application.Companion.tba
import com.dubrechi.ambag.adapter.CasesAdapter
import kotlinx.android.synthetic.main.activity_cases.*


class CasesActivity : AppCompatActivity() {

    private fun initCases(label:String) {

        var cases:MutableList<CaseDTO> = ArrayList()

        when (label) {
            getString(R.string.recovered) -> cases = recovered
            getString(R.string.admitted) -> cases = admitted
            getString(R.string.died) -> cases = died
            getString(R.string.tba) -> cases = tba
        }

        rv_cases.layoutManager = LinearLayoutManager(this)
        rv_cases.adapter = CasesAdapter(cases)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cases)

        initCases(intent.extras?.get("label").toString())
    }
}
