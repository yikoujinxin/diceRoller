package com.toa.diceroller.kotlin

import kotlin.math.max

fun main(){
    var a: Int = 10
    a = largerNumber(11, a)
    println("a = " + a)
    checkNumber(1L)
    for(i in 0 until 10 step 2){
        println(i)
    }
    for(j in 10 downTo 1 step 2){
        println(j)
    }
    val p = Person("Jack", 19)
    p.eat()
    Student()
    Student("Rose", 16)
    Student("class 4", 5,"Peter", 16)

}

fun largerNumber(num1: Int, num2: Int): Int{
    return max(num1, num2)
}

fun checkNumber(num: Number){
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}