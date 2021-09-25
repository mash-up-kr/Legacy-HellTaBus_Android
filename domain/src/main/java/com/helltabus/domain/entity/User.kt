package com.helltabus.domain.entity

data class User(
    val id: Long,
    val name: String,
    val age: Int
) : Entity
