package com.yonatankarp.adapter

/**
 * Device class (adaptee in the pattern). We want to reuse this class. Fishing
 * boat moves by sailing.
 */
internal class FishingBoat {
    fun sail() {
        logger.info("The fishing boat is sailing")
    }
}
