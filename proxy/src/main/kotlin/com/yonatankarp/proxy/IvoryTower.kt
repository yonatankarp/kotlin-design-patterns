package com.yonatankarp.proxy

/**
 * The object to be proxied.
 */
internal class IvoryTower : WizardTower {
    override fun enter(wizard: Wizard) = logger.info("$wizard enters the tower.")
}
