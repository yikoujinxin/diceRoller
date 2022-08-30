package com.toa.diceroller.kotlin

class Student(val sno:String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    constructor(name: String, age: Int): this("",0, name, age)
    constructor(): this("", 0){}

    override fun readBooks() {
        println(name + " is reading. ")
    }

    override fun doHomework() {
        println(name + " is doing homework.")
    }
}

fun main(){
    val student = Student("Jack", 19)
    doStudy(student)
    val cellphone1 = Cellphone("Samsung", 1299.99)
    val cellphone2 = Cellphone("Samsung", 1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
    Singleton.singletonTest()
    val list = listOf<String>("a","b","c","d","e","f")
    for (fruit in list){
        print(fruit)
    }

    val list2 = mutableListOf<String>("a","b","c","d","e","f")
    list2.add("0123")
    for (item in list2){
        println(item)
    }

    val map = mapOf<String,Int>("a" to 1,"b" to 2,"c" to 3,"d" to 4)
    for ((item, number) in map){
        println("item is " + item + ", number is " + number )
    }

    val list3 = listOf<String>("ab","cde","f")
    val lambda = { fruit: String -> fruit.length}
    println(list3.maxByOrNull(lambda))
    println(list3.map({item: String -> item.uppercase()}))
    println(list3.map(){item: String -> item.uppercase()})
    println(list3.map{item: String -> item.uppercase()})
    println(list3.map{item -> item.uppercase()})
    println(list3.map {it.uppercase()})
}

fun doStudy(study: Study){
    study.readBooks()
    study.doHomework()
}