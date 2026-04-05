package com.yonatankarp.state

/**
 * [State] in which the [Mammoth] is calm and peaceful.
 */
internal class PeacefulState(private val mammoth: Mammoth) : State {
    override fun observe() {
        logger.info("$mammoth is calm and peaceful.")
    }

    override fun onEnterState() {
        logger.info("$mammoth calms down.")
    }
}
