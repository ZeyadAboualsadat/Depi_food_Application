package com.example.navigationapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.citiesapplication.databinding.ItemCityBinding
import com.example.navigationapp.CityAdapter.MyViewHolder

class CityAdapter (val data: List<City>,val cityClickListener: CityClickListener)
    : ListAdapter<City, MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val binding: ItemCityBinding) : ViewHolder(binding.root) {
        companion object{
            fun from(parent: ViewGroup) : MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCityBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    interface CityClickListener {
        fun onCityClicked(city: City)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.city=data.get(position)
        holder.binding.ivCity.setImageResource(data.get(position).imageId)
        holder.binding.root.setOnClickListener {
            cityClickListener.onCityClicked(data.get(position))
        }

    }

}

class UserItemDiffCallback: DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

}