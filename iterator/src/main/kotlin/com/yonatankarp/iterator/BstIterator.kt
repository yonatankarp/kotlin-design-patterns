package com.yonatankarp.iterator

/**
 * In-order iterator for a binary search tree rooted at a [TreeNode].
 * Uses an explicit stack for O(h) space complexity where h is the tree height.
 */
internal class BstIterator<T : Comparable<T>>(
    root: TreeNode<T>,
) : Iterator<TreeNode<T>> {
    private val stack = ArrayDeque<TreeNode<T>>()

    init {
        pushLeftPath(root)
    }

    override fun hasNext(): Boolean = stack.isNotEmpty()

    override fun next(): TreeNode<T> {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val node = stack.removeLast()
        node.right?.let { pushLeftPath(it) }
        return node
    }

    private fun pushLeftPath(node: TreeNode<T>?) {
        var current = node
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }
    }
}
