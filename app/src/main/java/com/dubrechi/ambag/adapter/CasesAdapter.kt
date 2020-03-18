package com.dubrechi.ambag.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dubrechi.ambag.CaseDTO
import com.dubrechi.ambag.PatientUnderInvestigationDTO
import com.dubrechi.ambag.R
import kotlinx.android.synthetic.main.item_cases.view.*
import kotlinx.android.synthetic.main.item_outside_ph.view.*
import kotlinx.android.synthetic.main.item_pui.view.*

class CasesAdapter(val items: List<CaseDTO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_cases, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val case: CaseDTO = items[position]

        holder as ViewHolder
        holder.tv_case_no.text = case.case_no
        holder.tv_date.text = case.date
        holder.tv_age.text = case.age
        holder.tv_gender.text = case.gender
        holder.tv_nationality.text = case.nationality
        holder.tv_hospital_admitted_to.text = case.hospital_admitted_to
        holder.tv_had_recent_travel_history_abroad.text = case.had_recent_travel_history_abroad
        holder.tv_status.text = case.status
        holder.tv_notes.text = case.notes
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val tv_case_no: TextView  = view.tv_case_no
        val tv_date: TextView  = view.tv_date
        val tv_age: TextView  = view.tv_age
        val tv_gender: TextView  = view.tv_gender
        val tv_nationality: TextView  = view.tv_nationality
        val tv_hospital_admitted_to: TextView  = view.tv_hospital_admitted_to
        val tv_had_recent_travel_history_abroad: TextView  = view.tv_had_recent_travel_history_abroad
        val tv_status: TextView  = view.tv_status
        val tv_notes: TextView  = view.tv_notes

    }

}
