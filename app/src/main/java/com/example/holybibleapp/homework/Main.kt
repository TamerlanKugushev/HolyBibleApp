package com.example.holybibleapp.homework

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val triangle = Triangle(3, 4, 5)
        println(triangle.isRightTriangle())
    }
}