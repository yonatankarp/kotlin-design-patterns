package com.yonatankarp.proxy

/**
 * Interface for a tower that [Wizard] instances can enter.
 */
internal interface WizardTower {
    fun enter(wizard: Wizard)
}
