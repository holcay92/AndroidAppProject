package com.example.hipolabsproject

var memberList = arrayListOf<Member>()
val MEMBER = "memberEx"

data class Member(
    val company:String,
    val team:String,
    val name: String,
    val age: Int,
    val location: String,
    val github: String,
    val position: String,
    val years_in_hipo: Int
)