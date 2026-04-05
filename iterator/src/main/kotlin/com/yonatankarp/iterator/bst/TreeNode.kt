package com.yonatankarp.iterator.bst

/**
 * A node in a binary search tree that holds a [Comparable] value.
 *
 * @param T the type of value stored in the node
 * @property value the value held by this node
 */
class TreeNode<T : Comparable<T>>(val value: T) {
    /**
     * Left child (values less than [value]).
     */
    var left: TreeNode<T>? = null
        private set

    /**
     * Right child (values greater than or equal to [value]).
     */
    var right: TreeNode<T>? = null
        private set

    /**
     * Inserts a new value into the subtree rooted at this node.
     *
     * @param newValue the value to insert
     */
    fun insert(newValue: T) {
        val parent = parentNodeFor(newValue)
        parent.insertChild(newValue)
    }

    private fun parentNodeFor(target: T): TreeNode<T> {
        var parent = this
        var current: TreeNode<T>? = this
        while (current != null) {
            parent = current
            current =
                if (current.value > target) current.left else current.right
        }
        return parent
    }

    private fun insertChild(newValue: T) {
        if (value <= newValue) {
            right = TreeNode(newValue)
        } else {
            left = TreeNode(newValue)
        }
    }

    override fun toString(): String = value.toString()
}
