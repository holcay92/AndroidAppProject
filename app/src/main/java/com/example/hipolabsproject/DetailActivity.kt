package com.example.hipolabsproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hipolabsproject.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookID = intent.getIntExtra(MEMBER_ID_EXTRA, -1)
        val book = bookFromID(bookID)
        if(book != null)
        {
            binding.cover.setImageResource(book.cover)
            binding.title.text = book.title
            binding.description.text = book.description
            binding.author.text = book.author
        }
    }

    private fun bookFromID(bookID: Int): Member?
    {
        for(member in memberList)
        {
            if(member.id == bookID)
                return member
        }
        return null
    }
}