package com.example.hrybkov_l14

class Person (
    val name: String,
    val age: Int,
    var mother: Person? = null,
    var father: Person? = null,
)