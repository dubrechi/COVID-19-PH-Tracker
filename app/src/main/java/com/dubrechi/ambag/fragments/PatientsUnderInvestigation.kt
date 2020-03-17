package com.dubrechi.ambag.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dubrechi.ambag.CoroutineFunctions
import com.dubrechi.ambag.PatientUnderInvestigationDTO
import com.dubrechi.ambag.R
import com.dubrechi.ambag.adapter.CaseOutsidePHAdapter
import com.dubrechi.ambag.adapter.PUIAdapter
import kotlinx.android.synthetic.main.fragment_cases.*
import kotlinx.android.synthetic.main.fragment_cases_outisde_ph.*
import kotlinx.android.synthetic.main.fragment_patients_under_investigation.*
import kotlinx.android.synthetic.main.fragment_patients_under_investigation.swipeContainer
import kotlinx.android.synthetic.main.fragment_suspected_cases.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class PatientsUnderInvestigation : Fragment() {

    private lateinit var cases: MutableList<PatientUnderInvestigationDTO>

    private fun getPUI(){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {

                cases = CoroutineFunctions().getPUI()

                rv_pui.layoutManager = LinearLayoutManager(activity)
                rv_pui.adapter = PUIAdapter(cases)

                if (swipeContainer.isRefreshing) {
                    swipeContainer.isRefreshing = false
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_patients_under_investigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeContainer.setOnRefreshListener {

            cases.clear()
            rv_pui.adapter?.notifyDataSetChanged()

            getPUI()
        }

        getPUI()
    }

}