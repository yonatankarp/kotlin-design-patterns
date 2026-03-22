package com.yonatankarp.iterator

/**
 * A node in a binary search tree. Values less than or equal to this node
 * go left; values greater go right.
 */
internal class TreeNode<T : Comparable<T>>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null,
) {
    /**
     * Inserts a value into the subtree rooted at this node, maintaining
     * the BST invariant.
     */
    fun insert(newValue: T) {
        val parent = findParentFor(newValue)
        if (newValue <= parent.value) {
            parent.left = TreeNode(newValue)
        } else {
            parent.right = TreeNode(newValue)
        }
    }

    private fun findParentFor(newValue: T): TreeNode<T> {
        var current = this
        while (true) {
            val child = if (newValue <= current.value) current.left else current.right
            child ?: return current
            current = child
        }
    }

    override fun toString() = value.toString()
}
