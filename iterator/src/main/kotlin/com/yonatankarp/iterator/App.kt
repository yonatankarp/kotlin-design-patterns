package com.yonatankarp.iterator

import com.yonatankarp.iterator.bst.BstIterator
import com.yonatankarp.iterator.bst.TreeNode
import com.yonatankarp.iterator.list.ItemType
import com.yonatankarp.iterator.list.TreasureChest
import org.slf4j.LoggerFactory

internal val logger =
    LoggerFactory.getLogger("com.yonatankarp.iterator")

private val treasureChest = TreasureChest()

/**
 * Program entry point demonstrating the Iterator pattern with
 * both a [TreasureChest] item iterator and a [BstIterator].
 */
fun main() {
    demonstrateTreasureChestIteratorForType(ItemType.RING)
    demonstrateTreasureChestIteratorForType(ItemType.POTION)
    demonstrateTreasureChestIteratorForType(ItemType.WEAPON)
    demonstrateTreasureChestIteratorForType(ItemType.ANY)
    demonstrateBstIterator()
}

private fun demonstrateTreasureChestIteratorForType(
    itemType: ItemType,
) {
    logger.info("------------------------")
    logger.info("Item Iterator for ItemType $itemType: ")
    val itemIterator = treasureChest.iterator(itemType)
    itemIterator.forEach { logger.info(it.toString()) }
}

private fun demonstrateBstIterator() {
    logger.info("------------------------")
    logger.info("BST Iterator: ")
    val root = buildIntegerBst()
    val bstIterator = BstIterator(root)
    bstIterator.forEach { logger.info("Next node: ${it.value}") }
}

private fun buildIntegerBst(): TreeNode<Int> =
    TreeNode(8).apply {
        insert(3)
        insert(10)
        insert(1)
        insert(6)
        insert(14)
        insert(4)
        insert(7)
        insert(13)
    }
