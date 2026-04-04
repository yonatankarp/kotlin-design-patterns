package com.yonatankarp.prototype

/**
 * Abstract base for objects that can produce copies of themselves.
 */
abstract class Prototype<T> {
    /**
     * Returns a shallow copy of this instance.
     */
    abstract fun clone(): T
}
