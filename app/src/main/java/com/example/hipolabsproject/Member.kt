package com.example.hipolabsproject

var memberList = mutableListOf<Member>()

val MEMBER_ID_EXTRA = "memberEx"

class Member(
    var cover: Int,
    var author: String,
    var title: String,
    var description: String,
    val id: Int? = memberList.size
)