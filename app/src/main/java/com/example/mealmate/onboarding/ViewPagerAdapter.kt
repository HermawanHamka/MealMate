package com.example.mealmate.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealmate.R


class ViewPagerAdapter(private val viewPagerFragment: List<ViewPagerFragment>)
    : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)

        fun bind(viewPagerFragment: ViewPagerFragment){
            textDescription.text = viewPagerFragment.description
            imageIcon.setImageResource(viewPagerFragment.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
            parent,
            false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewPagerFragment[position])
    }

    override fun getItemCount(): Int {
        return viewPagerFragment.size
    }
}