package com.example.holybibleapp.homework

import org.junit.Assert.*
import org.junit.Test

class TriangleTest {

    @Test
    fun test_valid_data() {
        val triangle = Triangle(3, 4, 5)
        val actual = triangle.isRightTriangle()
        val expected = true
        assertEquals(expected, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_negative_data() {
        val triangle = Triangle(-3, -4, -5)
        val actual = triangle.isRightTriangle()
        val expected = false
        assertEquals(expected, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_invalid_triangle() {
        val triangle = Triangle(1, 2, 3)
        val actual = triangle.isRightTriangle()
        val expected = false
        assertEquals(expected, actual)
    }
}