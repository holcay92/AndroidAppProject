package com.example.hipolabsproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hipolabsproject.databinding.CardCellBinding
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter(private var members: ArrayList<Member>, private val clickListener: MemberClickListener)
    : RecyclerView.Adapter<CardViewHolder>() {

    val memberFilterList = ArrayList<Member>().apply {
        addAll(members)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return CardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindMember(members[position])
    }

    override fun getItemCount(): Int = members.size
    fun getFilter(): android.widget.Filter {
        return memberFilter
    }

    private val memberFilter = object : android.widget.Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<Member> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                memberFilterList.let { filteredList.addAll(it) }
            } else {
                val query = constraint.toString().trim().lowercase()
                memberFilterList.forEach {
                    if (it.name.lowercase(Locale.ROOT).contains(query)) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                members.clear()
                members.addAll(results.values as ArrayList<Member>)
                notifyDataSetChanged()
            }
        }
    }
}