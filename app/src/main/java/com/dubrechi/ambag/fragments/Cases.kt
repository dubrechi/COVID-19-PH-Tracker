package com.dubrechi.ambag.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dubrechi.ambag.CaseDTO
import com.dubrechi.ambag.CoroutineFunctions
import com.dubrechi.ambag.R
import kotlinx.android.synthetic.main.fragment_cases.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class Cases : Fragment() {

    private fun getCases() {
        CoroutineScope(IO).launch {
            withContext(Main) {

                val cases = CoroutineFunctions().getCases()
                val recovered: MutableList<CaseDTO> = ArrayList()
                val admitted: MutableList<CaseDTO> = ArrayList()
                val died: MutableList<CaseDTO> = ArrayList()

                for (case in cases) {

                    when {
                        case.status == "Recovered" -> recovered.add(case)
                        case.status == "Admitted" -> admitted.add(case)
                        case.status == "Died" -> died.add(case)
                    }

                }

                tv_cases.text = "Total \n${cases.count()}"
                tv_recovered.text = "Recovered \n${recovered.count()}"
                tv_admitted.text = "Admitted \n${admitted.count()}"
                tv_died.text = "Died \n${died.count()}"

                if (swipeContainer.isRefreshing) {
                    swipeContainer.isRefreshing = false
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_cases, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCases()

        swipeContainer.setOnRefreshListener {
            tv_cases.text = "Total"
            tv_recovered.text = "Recovered"
            tv_admitted.text = "Admitted"
            tv_died.text = "Died"

            getCases()
        }
    }
}