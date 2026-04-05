package com.yonatankarp.observer.generic

/**
 * Generic observer interface parameterised by the subject type [S]
 * and the argument type [A] passed during notifications.
 */
fun interface Observer<S, A> {
    /**
     * Called when [subject] changes, with [argument] describing the
     * change.
     */
    fun update(subject: S, argument: A)
}
