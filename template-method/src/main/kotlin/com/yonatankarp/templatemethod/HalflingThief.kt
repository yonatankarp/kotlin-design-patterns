package com.yonatankarp.templatemethod

/**
 * A halfling thief that uses a [StealingMethod] to steal.
 *
 * The method can be swapped at runtime via [changeMethod],
 * demonstrating how the Template Method pattern decouples the
 * algorithm skeleton from its concrete steps.
 */
internal class HalflingThief(private var method: StealingMethod) {
    /**
     * Executes the current stealing method.
     */
    fun steal() {
        method.steal()
    }

    /**
     * Replaces the current stealing method with the given [method].
     *
     * @param method the new stealing method to use
     */
    fun changeMethod(method: StealingMethod) {
        this.method = method
    }
}
