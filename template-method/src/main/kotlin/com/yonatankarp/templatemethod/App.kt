package com.yonatankarp.templatemethod

import org.slf4j.LoggerFactory

/**
 * Template Method defines the skeleton of an algorithm in a method,
 * deferring some steps to subclasses. It lets subclasses redefine
 * certain steps without changing the algorithm's structure.
 *
 * In this example [HalflingThief] uses a [StealingMethod] whose
 * concrete steps vary between [HitAndRunMethod] and [SubtleMethod].
 */

internal val logger =
    LoggerFactory.getLogger("com.yonatankarp.templatemethod")

/**
 * Program entry point.
 */
fun main() {
    val thief = HalflingThief(HitAndRunMethod())
    thief.steal()
    thief.changeMethod(SubtleMethod())
    thief.steal()
}
