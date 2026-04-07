package com.yonatankarp.visitor

/**
 * Visitor interface for the army [Unit] hierarchy.
 *
 * Each concrete visitor implements an operation for every unit
 * type in the hierarchy.
 */
internal interface UnitVisitor {
    /**
     * Visits a [Soldier] unit.
     *
     * @param soldier the soldier to visit
     */
    fun visit(soldier: Soldier)

    /**
     * Visits a [Sergeant] unit.
     *
     * @param sergeant the sergeant to visit
     */
    fun visit(sergeant: Sergeant)

    /**
     * Visits a [Commander] unit.
     *
     * @param commander the commander to visit
     */
    fun visit(commander: Commander)
}
