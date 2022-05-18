package com.example.myappproject.models

import java.time.LocalDate
import java.util.*

data class Student (
    var login: String = "",
    var password: String = "",
    var name: String = "",
    var surname: String = "",
    var birthDate: LocalDate = LocalDate.now(),
    var ratePlace: Int = 0,
    var group: Group = Group(1,"1")

//    constructor(
//        login: String,
//        password: String,
//        name: String,
//        surname: String,
//        ratePlace: Int,
//        group: Group
//    ) {
//        this.login = login
//        this.password = password
//        this.name = name
//        this.surname = surname
//        this.ratePlace = ratePlace
//        this.group = group
//    }
//
//    constructor(
//        login: String,
//        password: String,
//        name: String,
//        surname: String,
//        birthDate: LocalDate,
//        ratePlace: Int,
//        group: Group
//    ) {
//        this.login = login
//        this.password = password
//        this.name = name
//        this.surname = surname
//        this.birthDate = birthDate
//        this.ratePlace = ratePlace
//        this.group = group
//    }
//
//    constructor()


)