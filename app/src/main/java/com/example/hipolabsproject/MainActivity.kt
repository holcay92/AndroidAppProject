package com.example.hipolabsproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hipolabsproject.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity(), MemberClickListener
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//working area
        """ val json = resources.openRawResource(R.raw.hipo_data)
          .bufferedReader()
          .use { it.readText() }

      println(json)"""

        val str =  loadJSON(this)
        // println(str)

        val `object` = JSONObject(str)
        val array: JSONArray = `object`.getJSONArray("members")
        //val data: JSONArray = `object`.getJSONArray("members")
        println("empty line")
        println("array" + array)
        println("empty line")
//working area
        populateBooks()

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = CardAdapter(memberList, mainActivity)
        }
    }
    override fun onClick(book: Member)
    {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(MEMBER_ID_EXTRA, book.id)
        startActivity(intent)
    }

    private fun populateBooks()
    {
        val book1 = Member(
            R.drawable.abtm,
            "Victoria Devine",
            "AGELESS BODY, TIMELESS MIND",
            "The definitive text on the healing powers of the mind/body connection. In Ageless Body, Timeless Mind, world-renowned pioneer of integrative medicine Deepak Chopra goes beyond ancient mind/body wisdom and current anti-ageing research to show that you do not have to grow old. With the passage of time, you can retain your physical vitality, creativity, memory and self-esteem. Based on the theories of Ayurveda and groundbreaking research, Chopra reveals how we can use our innate capacity for balance to direct the way our bodies metabolize time and achieve our unbounded potential."
        )
        memberList.add(book1)

        val book2 = Member(
            R.drawable.tmom,
            "Amanda Lohrey",
            "THE MIRACLE OF MINDFULNESS",
            "This is the definitive book on mindfulness from the beloved Zen master and Nobel Peace Prize nominee Thich Nhat Hanh. With his signature clarity and warmth, he shares practical exercises and anecdotes to help us arrive at greater self-understanding and peacefulness, whether we are beginners or advanced students.\n" + "\n" + "Beautifully written, The Miracle of Mindfulness is the essential guide to welcoming presence in your life and truly living in the moment from the father of mindfulness.\n"
        )
        memberList.add(book2)

        val book3 = Member(
            R.drawable.trlt,
            "M. Scott Peck",
            "THE ROAD LESS TRAVELLED",
            "A timeless classic in personal development, The Road Less Travelled is a landmark work that has inspired millions. Drawing on the experiences of his career as a psychiatrist, Scott Peck combines scientific and spiritual views to guide us through the difficult, painful times in life by showing us how to confront our problems through the key principles of discipline, love and grace.Teaching us how to distinguish dependency from love, how to become a more sensitive parent and how to connect with your true self, this incredible book is the key to accepting and overcoming life's challenges and achieving a higher level of self-understanding."
        )
        memberList.add(book3)

        val book4 = Member(
            R.drawable.iewu,
            "Colleen Hoover",
            "IT ENDS WITH US",
            "'A brave and heartbreaking novel that digs its claws into you and doesn't let go, long after you've finished it' Anna Todd, author of the After series\n" + "\n" + "'A glorious and touching read, a forever keeper' USA Today\n" + "\n" + "'Will break your heart while filling you with hope' Sarah Pekkanen, Perfect Neighbors\n",
        )
        memberList.add(book4)

        val book5 = Member(
            R.drawable.ips,
            "Ross Coulthart",
            "IN PLAIN SIGHT",
            "Investigative journalist Ross Coulthart has been intrigued by UFOs since mysterious glowing lights were reported near New Zealand's Kaikoura mountains when he was a teenager. The 1978 sighting is just one of thousands since the 1940s, and yet research into UFOs is still seen as the realm of crackpots and conspiracy theorists."
        )
        memberList.add(book5)

        val book6 = Member(
            R.drawable.ttmc,
            "Richard Osman",
            "THE THURSDAY MURDER CLUB",
            "In a peaceful retirement village, four unlikely friends meet up once a week to investigate unsolved murders.\n" + "\n" + "But when a brutal killing takes place on their very doorstep, the Thursday Murder Club find themselves in the middle of their first live case.\n" + "\n" + "Elizabeth, Joyce, Ibrahim and Ron might be pushing eighty but they still have a few tricks up their sleeves.",
        )
        memberList.add(book6)

        val book7 = Member(
            R.drawable.wyam,
            "Michael Robotham",
            "WHEN YOU ARE MINE",
            "Philomena McCarthy has defied the odds and become a promising young officer with the Metropolitan Police despite being the daughter of a notorious London gangster. Called to the scene of a domestic assault one day, she rescues a bloodied young woman, Tempe Brown, the mistress of a decorated detective. The incident is hushed up, but Phil has unwittingly made a dangerous enemy with powerful friends.\n"
        )
        memberList.add(book7)


        memberList.add(book1)
        memberList.add(book2)
        memberList.add(book3)
        memberList.add(book4)
        memberList.add(book5)
        memberList.add(book6)
        memberList.add(book7)
    }

    private fun loadJSON(context: Context): String? {

        var input: InputStream? = null
        var input1: InputStream? = null
        var jsonString: String

        try {
            //  input1 = context.
            input = context.assets.open("hipo_data")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString = String(buffer)
            return jsonString
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            input?.close()
        }
        return null
    }
}