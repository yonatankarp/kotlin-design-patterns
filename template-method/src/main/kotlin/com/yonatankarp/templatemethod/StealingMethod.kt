package com.yonatankarp.templatemethod

import org.slf4j.LoggerFactory

/**
 * Defines the skeleton of a stealing algorithm, deferring specific
 * steps to subclasses.
 *
 * The [steal] method is the template method that orchestrates the
 * invariant sequence: pick a target, confuse the target, then steal
 * the item. Subclasses provide the concrete behaviour for each step.
 */
abstract class StealingMethod {
    private val logger = LoggerFactory.getLogger(javaClass)

    /**
     * Selects the target to steal from.
     *
     * @return the name of the chosen target
     */
    protected abstract fun pickTarget(): String

    /**
     * Distracts or confuses the [target] so the theft can succeed.
     *
     * @param target the name of the target
     */
    protected abstract fun confuseTarget(target: String)

    /**
     * Steals the item from the [target].
     *
     * @param target the name of the target
     */
    protected abstract fun stealTheItem(target: String)

    /**
     * Template method that defines the stealing algorithm.
     *
     * Calls [pickTarget], [confuseTarget], and [stealTheItem] in
     * sequence.
     */
    fun steal() {
        val target = pickTarget()
        logger.info("The target has been chosen as $target.")
        confuseTarget(target)
        stealTheItem(target)
    }
}
