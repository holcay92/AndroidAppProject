package com.example.hipolabsproject

import androidx.recyclerview.widget.RecyclerView
import com.example.hipolabsproject.databinding.CardCellBinding



class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: MemberClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindBook(member: Member)
    {
        cardCellBinding.cover.setImageResource(member.cover)
        cardCellBinding.title.text = member.title
        cardCellBinding.author.text = member.author

        cardCellBinding.cardView.setOnClickListener{
            clickListener.onClick(member)
        }
    }
}