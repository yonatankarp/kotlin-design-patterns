package com.yonatankarp.state

/**
 * [State] in which the [Mammoth] is angry and furious.
 */
internal class AngryState(private val mammoth: Mammoth) : State {
    override fun observe() {
        logger.info("$mammoth is furious!")
    }

    override fun onEnterState() {
        logger.info("$mammoth gets angry!")
    }
}
