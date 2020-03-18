package com.dubrechi.ambag.fragments

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.dubrechi.ambag.Application.Companion.admitted
import com.dubrechi.ambag.Application.Companion.died
import com.dubrechi.ambag.Application.Companion.recovered
import com.dubrechi.ambag.CoroutineFunctions
import com.dubrechi.ambag.R
import com.dubrechi.ambag.activities.CasesActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.fragment_cases.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class Cases : Fragment(), OnChartValueSelectedListener{

    override fun onNothingSelected() {
        return
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        val pieEntry = e as PieEntry
        val intent = Intent (activity, CasesActivity::class.java)
        intent.putExtra("label",pieEntry.label.toString())
        activity?.startActivity(intent)
    }

    private fun getCases() {
        CoroutineScope(IO).launch {
            withContext(Main) {

                val cases = CoroutineFunctions().getCases()

                recovered.clear()
                admitted.clear()
                died.clear()

                for (case in cases) {

                    when {
                        case.status == getString(R.string.recovered) -> recovered.add(case)
                        case.status == getString(R.string.admitted) -> admitted.add(case)
                        case.status == getString(R.string.died) -> died.add(case)
                    }

                }

                val listPie = ArrayList<PieEntry>()
                val listColors = ArrayList<Int>()

                listPie.add(PieEntry(recovered.count().toFloat(), getString(R.string.recovered)))
                listColors.add(ContextCompat.getColor(context!!,R.color.recovered))

                listPie.add(PieEntry(admitted.count().toFloat(), getString(R.string.admitted)))
                listColors.add(ContextCompat.getColor(context!!, R.color.admitted))

                listPie.add(PieEntry(died.count().toFloat(), getString(R.string.died)))
                listColors.add(ContextCompat.getColor(context!!, R.color.died))

                val pieDataSet = PieDataSet(listPie, "")
                pieDataSet.colors = listColors
                pieDataSet.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
                pieDataSet.sliceSpace = 2f

                val pieData = PieData(pieDataSet)
                pieData.setValueTextSize(50f)

                mp_piechart.data = pieData

                mp_piechart.setUsePercentValues(false)
                mp_piechart.isDrawHoleEnabled = true
                mp_piechart.description.isEnabled = false
                mp_piechart.setEntryLabelColor(R.color.dark_label)
                mp_piechart.setEntryLabelTextSize(13f)
                mp_piechart.setEntryLabelTypeface(Typeface.DEFAULT_BOLD)
                mp_piechart.animateY(1400, Easing.EaseInOutQuad)
                mp_piechart.centerText = "Total \n${cases.count()}"
                mp_piechart.setCenterTextSize(30f)
                mp_piechart.setHoleColor(ContextCompat.getColor(context!!,R.color.bg_color))

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

        mp_piechart.setOnChartValueSelectedListener(this)
        mp_piechart.setTouchEnabled(true)

        swipeContainer.setOnRefreshListener {
            getCases()
        }
    }
}