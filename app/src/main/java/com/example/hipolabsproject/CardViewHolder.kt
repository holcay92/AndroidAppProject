package com.example.hipolabsproject

import androidx.recyclerview.widget.RecyclerView
import com.example.hipolabsproject.databinding.CardCellBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: MemberClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindMember(member: Member) {
        cardCellBinding.title.text = member.name
        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(member)
        }
    }
}