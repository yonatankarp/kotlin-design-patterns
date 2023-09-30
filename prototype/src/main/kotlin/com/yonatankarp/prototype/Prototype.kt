package com.yonatankarp.prototype

/**
 * Prototype.
 */
abstract class Prototype<T> {
    /**
     * Object a shallow copy of this object or null if this object is not Cloneable.
     */
    abstract fun clone(): T
}
