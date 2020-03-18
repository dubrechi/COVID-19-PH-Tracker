package com.dubrechi.ambag.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dubrechi.ambag.CheckpointsDTO
import com.dubrechi.ambag.MainActivity
import com.dubrechi.ambag.R
import kotlinx.android.synthetic.main.item_checkpoints.*
import kotlinx.android.synthetic.main.item_checkpoints.view.*

class CheckpointsAdapter (private val items: MutableList<CheckpointsDTO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var context: MainActivity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_checkpoints, parent, false)
        context = parent.context as MainActivity

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val checkpointsDTO: CheckpointsDTO = items[position]

        holder as ViewHolder
        holder.tvDistrict.text = checkpointsDTO.district
        holder.tvCity.text = checkpointsDTO.city

        holder.tvLocation.text = checkpointsDTO.location
        holder.tvType.text = checkpointsDTO.type

        holder.tvLatitude.text = checkpointsDTO.lat
        holder.tvLongitude.text = checkpointsDTO.lng


        if (checkpointsDTO.description?.trim().toString() == "") {

            context?.tv_label_description?.visibility = View.GONE
            context?.tv_description?.visibility = View.GONE

        } else {

            holder.tvDescription.text = checkpointsDTO.description
            holder.tvDescriptionLabel.text = "Description"
        }

    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvDistrict: TextView = view.tv_district
        val tvCity: TextView = view.tv_city

        val tvLocation: TextView = view.tv_location
        val tvType: TextView = view.tv_type

        val tvLatitude: TextView = view.tv_latitude
        val tvLongitude: TextView = view.tv_longitude

        val tvDescription: TextView = view.tv_description
        val tvDescriptionLabel: TextView = view.tv_label_description
    }
}