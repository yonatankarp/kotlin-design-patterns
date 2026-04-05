package com.yonatankarp.templatemethod

import org.slf4j.LoggerFactory

/**
 * A hit-and-run implementation of [StealingMethod].
 *
 * The thief approaches the target from behind, grabs the item, and
 * runs away as fast as possible.
 */
internal class HitAndRunMethod : StealingMethod() {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun pickTarget(): String = "old goblin woman"

    override fun confuseTarget(target: String) {
        logger.info("Approach the $target from behind.")
    }

    override fun stealTheItem(target: String) {
        logger.info("Grab the handbag and run away fast!")
    }
}
