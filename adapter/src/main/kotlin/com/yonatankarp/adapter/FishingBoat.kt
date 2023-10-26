package com.yonatankarp.adapter

import org.slf4j.LoggerFactory

/**
 * Device class (adaptee in the pattern). We want to reuse this class. Fishing
 * boat moves by sailing.
 */
internal class FishingBoat {
    fun sail() {
        logger.info("The fishing boat is sailing")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FishingBoat::class.java)
    }
}
