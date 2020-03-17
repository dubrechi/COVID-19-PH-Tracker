package com.dubrechi.ambag.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dubrechi.ambag.PatientUnderInvestigationDTO
import com.dubrechi.ambag.R
import kotlinx.android.synthetic.main.item_outside_ph.view.*
import kotlinx.android.synthetic.main.item_pui.view.*

class PUIAdapter(val items: List<PatientUnderInvestigationDTO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_pui, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val pui: PatientUnderInvestigationDTO = items[position]

        holder as ViewHolder
        holder.tv_region.text = pui.region
        holder.tv_sadmitted.text = pui.current_pui_status.suspected_cases?.admitted
        holder.tv_sdeaths.text = pui.current_pui_status.suspected_cases?.deaths
        holder.tv_cadmitted.text = pui.current_pui_status.confirmed_cases?.admitted
        holder.tv_crecoveries.text = pui.current_pui_status.confirmed_cases?.recoveries
        holder.tv_cdeaths.text = pui.current_pui_status.confirmed_cases?.deaths
        holder.tv_total.text = pui.total
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val tv_region: TextView  = view.tv_region
        val tv_sadmitted = view.tv_sadmitted
        val tv_sdeaths = view.tv_sdeaths
        val tv_cadmitted = view.tv_cadmitted
        val tv_crecoveries = view.tv_crecoveries
        val tv_cdeaths = view.tv_cdeaths
        val tv_total = view.tv_total
    }

}
