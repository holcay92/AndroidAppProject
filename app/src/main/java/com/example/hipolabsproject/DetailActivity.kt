package com.example.hipolabsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hipolabsproject.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name: String? = intent.getStringExtra(MEMBER)
        val member = bookFromID(name.toString())
        if(member != null) {
            binding.name.text = member.name
            binding.age.text = member.age.toString()
            binding.location.text = member.location
            binding.github.text = member.github
            binding.yearsInHipo.text = member.years_in_hipo.toString()
            binding.position.text = member.position
            binding.company.text = member.company
            binding.team.text = member.team
        }
    }

    private fun bookFromID(name: String): Member?
    {
        for(member in memberList)
        {
            if(member.name == name)
                return member
        }
        return null
    }
}