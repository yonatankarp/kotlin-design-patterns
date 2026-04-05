package com.yonatankarp.state

/**
 * Defines the behavior associated with a particular state
 * of the [Mammoth].
 */
internal interface State {
    /**
     * Called when the [Mammoth] transitions into this state.
     */
    fun onEnterState()

    /**
     * Observes the [Mammoth] in this state.
     */
    fun observe()
}
