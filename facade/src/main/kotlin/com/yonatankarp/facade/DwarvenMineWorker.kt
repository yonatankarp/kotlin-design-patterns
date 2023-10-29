package com.yonatankarp.facade

internal abstract class DwarvenMineWorker {
    abstract val name: String

    abstract fun work()

    fun goToSleep() = logger.info("$name goes to sleep.")

    fun wakeUp() = logger.info("$name wakes up.")

    fun goHome() = logger.info("$name goes home.")

    fun goToMine() = logger.info("$name goes to the mine.")

    internal fun action(action: Action) =
        when (action) {
            Action.GO_TO_SLEEP -> goToSleep()
            Action.WAKE_UP -> wakeUp()
            Action.GO_HOME -> goHome()
            Action.GO_TO_MINE -> goToMine()
            Action.WORK -> work()
        }

    /**
     * Perform actions.
     */
    internal fun action(vararg actions: Action) {
        actions.forEach { action: Action -> this.action(action) }
    }

    internal enum class Action {
        GO_HOME,
        GO_TO_MINE,
        GO_TO_SLEEP,
        WAKE_UP,
        WORK,
;
    }
}
