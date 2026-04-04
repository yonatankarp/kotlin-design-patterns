package com.yonatankarp.decorator

/**
 * Represents a troll that can attack, flee, and report its power.
 */
interface Troll {
    val attackPower: Int
    fun attack()

    fun fleeBattle()
}
