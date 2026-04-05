package com.yonatankarp.iterator.bst

import java.util.ArrayDeque

/**
 * An in-order [Iterator] over a binary search tree of [TreeNode]
 * elements.
 *
 * For a BST with integer values, nodes are returned in ascending
 * natural order (1, 2, 3, ...).
 *
 * Uses O(h) extra space, where h is the height of the tree.
 *
 * @param T the comparable type stored in each [TreeNode]
 * @param root the root of the BST (may be null for an empty tree)
 */
class BstIterator<T : Comparable<T>>(
    root: TreeNode<T>?,
) : Iterator<TreeNode<T>> {
    private val pathStack = ArrayDeque<TreeNode<T>>()

    init {
        pushPathToNextSmallest(root)
    }

    override fun hasNext(): Boolean = pathStack.isNotEmpty()

    /**
     * Returns the next [TreeNode] in in-order traversal.
     *
     * @throws NoSuchElementException if there are no more elements
     */
    override fun next(): TreeNode<T> {
        if (pathStack.isEmpty()) {
            throw NoSuchElementException()
        }
        val next = pathStack.pop()
        pushPathToNextSmallest(next.right)
        return next
    }

    private fun pushPathToNextSmallest(node: TreeNode<T>?) {
        var current = node
        while (current != null) {
            pathStack.push(current)
            current = current.left
        }
    }
}
