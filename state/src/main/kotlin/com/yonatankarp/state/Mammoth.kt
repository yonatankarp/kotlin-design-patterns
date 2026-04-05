package com.yonatankarp.state

/**
 * Context whose behavior changes based on its internal [State].
 *
 * The mammoth alternates between [PeacefulState] and
 * [AngryState] as time passes.
 */
internal class Mammoth {
    private var state: State = PeacefulState(this)

    /**
     * Advances time, toggling the mammoth's mood between
     * peaceful and angry.
     */
    fun timePasses() {
        val newState = when (state) {
            is PeacefulState -> AngryState(this)
            else -> PeacefulState(this)
        }
        changeStateTo(newState)
    }

    /**
     * Observes the mammoth's current behavior.
     */
    fun observe() {
        state.observe()
    }

    private fun changeStateTo(newState: State) {
        state = newState
        state.onEnterState()
    }

    override fun toString() = "The mammoth"
}
