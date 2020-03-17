package com.dubrechi.ambag.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dubrechi.ambag.CaseDTO
import com.dubrechi.ambag.CoroutineFunctions
import com.dubrechi.ambag.R
import com.dubrechi.ambag.adapter.CaseOutsidePHAdapter
import kotlinx.android.synthetic.main.fragment_cases.*
import kotlinx.android.synthetic.main.fragment_cases_outisde_ph.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class CasesOutsidePH : Fragment() {

    private fun getCasesOutsidePH(){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {

                val cases = CoroutineFunctions().getCasesOutsidePH()

                rv_outside_ph.layoutManager = LinearLayoutManager(activity)
                rv_outside_ph.adapter = CaseOutsidePHAdapter(cases)

            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_cases_outisde_ph, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCasesOutsidePH()
    }
}