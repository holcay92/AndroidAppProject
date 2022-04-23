package com.example.hipolabsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hipolabsproject.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity(), MemberClickListener
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {

            val jsonObj = JSONObject(getJSONFromAssets()!!)
            val jsonArray = jsonObj.getJSONArray("members")

            val company = JSONObject(getJSONFromAssets()!!)["company"].toString()
            val team = JSONObject(getJSONFromAssets()!!)["team"].toString()


            for (i in 0 until jsonArray.length()) {

                // creating a JSONObject for fetching a members data
                val member = jsonArray.getJSONObject(i)

                // Getting inputs and store them in variables
                val age = member.getInt("age")
                val name = member.getString("name")
                val location = member.getString("location")
                val github = member.getString("github")

                // Create a object for getting hipo detail data from JSONObject
                val hipo = member.getJSONObject("hipo")
                val position = hipo.getString("position")
                val years_in_hipo = hipo.getInt("years_in_hipo")

                val memberDetails = Member(company,team,name, age, location, github, position, years_in_hipo)

                memberList.add(memberDetails)
                println(memberDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = CardAdapter(memberList, mainActivity)
        }
    }

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("file.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun onClick(member: Member)
    {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(MEMBER, member.name)
        startActivity(intent)
    }
}