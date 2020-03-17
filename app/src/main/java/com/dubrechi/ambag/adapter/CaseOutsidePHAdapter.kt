package com.dubrechi.ambag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dubrechi.ambag.CaseOutsidePhDTO
import com.dubrechi.ambag.R
import kotlinx.android.synthetic.main.item_outside_ph.view.*

class CaseOutsidePHAdapter(val items: List<CaseOutsidePhDTO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_outside_ph, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val caseOut: CaseOutsidePhDTO = items[position]

        holder as ViewHolder
        holder.tv_country_territory_place.text = caseOut.country_territory_place
        holder.tv_confirmed.text = caseOut.confirmed
        holder.tv_recovered.text = caseOut.recovered
        holder.tv_died.text = caseOut.died
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val tv_country_territory_place: TextView  = view.tv_country_territory_place
        val tv_confirmed = view.tv_confirmed
        val tv_recovered = view.tv_recovered
        val tv_died = view.tv_died
    }

}
