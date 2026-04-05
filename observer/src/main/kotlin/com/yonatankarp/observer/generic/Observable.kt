package com.yonatankarp.observer.generic

/**
 * Generic observable base class inspired by
 * *Java Generics and Collections* (Naftalin and Wadler).
 *
 * Subclasses specify their own type [S] so that observers receive
 * a correctly-typed reference to the subject, along with an
 * argument of type [A].
 *
 * @param S the concrete subject type (self-type)
 * @param A the argument type passed to observers on notification
 */
@Suppress("UNCHECKED_CAST")
open class Observable<S : Observable<S, A>, A> {
    private val observers = mutableListOf<Observer<S, A>>()

    /**
     * Registers an [observer] to receive notifications.
     */
    fun addObserver(observer: Observer<S, A>) {
        observers.add(observer)
    }

    /**
     * Unregisters an [observer] so it no longer receives
     * notifications.
     */
    fun removeObserver(observer: Observer<S, A>) {
        observers.remove(observer)
    }

    /**
     * Notifies every registered observer with the given [argument].
     */
    fun notifyObservers(argument: A) {
        observers.forEach { it.update(this as S, argument) }
    }
}
