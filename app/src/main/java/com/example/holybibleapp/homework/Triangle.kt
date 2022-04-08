package com.example.holybibleapp.homework

class Triangle(private val sideA: Int, private val sideB: Int, private val sideC: Int) {

    init {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw IllegalArgumentException("Стороны треугольника должны быть положительными")
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw IllegalArgumentException("Стороны треугольника должны быть положительными")
        }
    }

    fun isRightTriangle(): Boolean {
        return sideA.square() + sideB.square() == sideC.square() ||
                sideA.square() + sideC.square() == sideB.square() ||
                sideB.square() + sideC.square() == sideA.square()
    }
}

private fun Int.square(): Int {
    return this * this
}