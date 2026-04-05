package com.yonatankarp.templatemethod

import org.slf4j.LoggerFactory

/**
 * A subtle implementation of [StealingMethod].
 *
 * The thief approaches the target with a tearful hug and picks
 * their pocket during the embrace.
 */
internal class SubtleMethod : StealingMethod() {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun pickTarget(): String = "shop keeper"

    override fun confuseTarget(target: String) {
        logger.info("Approach the $target with tears running and hug him!")
    }

    override fun stealTheItem(target: String) {
        logger.info("While in close contact grab the $target's wallet.")
    }
}
