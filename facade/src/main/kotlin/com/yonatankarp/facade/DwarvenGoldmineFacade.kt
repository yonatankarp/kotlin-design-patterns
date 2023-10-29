package com.yonatankarp.facade

import com.yonatankarp.facade.DwarvenMineWorker.Action

/**
 * DwarvenGoldmineFacade provides a single interface through which users can
 * operate the subsystems.
 *
 * This makes the goldmine easier to operate and cuts the dependencies from the
 * goldmine user to the subsystems.
 */
internal class DwarvenGoldmineFacade {
    private val workers: List<DwarvenMineWorker> = listOf(
        DwarvenGoldDigger(),
        DwarvenCartOperator(),
        DwarvenTunnelDigger()
    )

    fun startNewDay() {
        makeActions(workers, Action.WAKE_UP, Action.GO_TO_MINE)
    }

    fun digOutGold() {
        makeActions(workers, Action.WORK)
    }

    fun endDay() {
        makeActions(workers, Action.GO_HOME, Action.GO_TO_SLEEP)
    }

    private fun makeActions(
        workers: Collection<DwarvenMineWorker>,
        vararg actions: Action,
    ) {
        workers.forEach { worker: DwarvenMineWorker ->
            worker.action(*actions)
        }
    }
}
