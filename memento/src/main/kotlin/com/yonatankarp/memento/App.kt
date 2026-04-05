package com.yonatankarp.memento

import org.slf4j.LoggerFactory
import java.util.ArrayDeque

/**
 * The Memento pattern provides the ability to restore an object
 * to its previous state (undo via rollback).
 *
 * It is implemented with three objects: the originator, a
 * caretaker, and a memento. The originator is some object that
 * has an internal state. The caretaker does something to the
 * originator but wants to be able to undo the change. It first
 * asks the originator for a memento object, then performs its
 * operations. To roll back, it returns the memento to the
 * originator.
 *
 * In this example the [Star] gives out a [StarMemento] that
 * contains its state. Later the memento can be set back to the
 * star, restoring the state.
 */
private const val INITIAL_AGE = 10_000_000
private const val INITIAL_MASS = 500_000

private val logger = LoggerFactory.getLogger("com.yonatankarp.memento.App")

fun main() {
    val states = ArrayDeque<StarMemento>()

    val star = Star(StarType.SUN, INITIAL_AGE, INITIAL_MASS)
    logger.info(star.toString())
    states.push(star.memento)

    star.timePasses()
    logger.info(star.toString())
    states.push(star.memento)

    star.timePasses()
    logger.info(star.toString())
    states.push(star.memento)

    star.timePasses()
    logger.info(star.toString())
    states.push(star.memento)

    star.timePasses()
    logger.info(star.toString())

    while (states.isNotEmpty()) {
        star.memento = states.pop()
        logger.info(star.toString())
    }
}
