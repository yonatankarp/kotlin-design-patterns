package com.yonatankarp.proxy

/**
 * The proxy controlling access to the [IvoryTower].
 */
internal class WizardTowerProxy(private val tower: WizardTower) : WizardTower {
    private var numWizards = 0

    override fun enter(wizard: Wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            tower.enter(wizard)
            numWizards++
        } else {
            logger.info("$wizard is not allowed to enter!")
        }
    }

    companion object {
        private const val NUM_WIZARDS_ALLOWED = 3
    }
}
