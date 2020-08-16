package com.modtion.kompis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main_menu.view.*

class MainMenuAdapter(private val listener: (MenuData) -> Unit): RecyclerView.Adapter<MainMenuAdapter.MenuViewHolder>() {

    private val data: ArrayList<MenuData> = ArrayList()

    fun setData(items: ArrayList<MenuData>?){
        if (items==null) return
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder
            = MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_menu, parent, false))

    override fun getItemCount(): Int
        = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            response: MenuData,
            listener: (MenuData) -> Unit
        ){
            with(itemView){
                item_main_icon.setImageResource(response.icon)
                item_main_title.text = response.desc
                itemView.setOnClickListener { listener(response) }
            }
        }
    }
}