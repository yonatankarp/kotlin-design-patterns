package com.yonatankarp.memento

/**
 * The originator whose internal state can be captured into a
 * [StarMemento] and later restored from it.
 *
 * A [Star] evolves through several [StarType] stages as time
 * passes. The memento mechanism allows the caretaker to roll
 * back the star to any previously saved state without exposing
 * implementation details.
 */
internal class Star(
    private var type: StarType,
    private var ageYears: Int,
    private var massTons: Int,
) {
    /**
     * Advances the star to its next lifecycle stage, doubling
     * its age and multiplying its mass eightfold before
     * applying the type-specific transition.
     */
    fun timePasses() {
        ageYears *= 2
        massTons *= 8
        when (type) {
            StarType.SUN -> type = StarType.RED_GIANT
            StarType.RED_GIANT -> type = StarType.WHITE_DWARF
            StarType.WHITE_DWARF -> type = StarType.SUPERNOVA
            StarType.SUPERNOVA -> type = StarType.DEAD
            StarType.DEAD -> {
                ageYears *= 2
                massTons = 0
            }
        }
    }

    /**
     * Captures the current state of this star into a
     * [StarMemento].
     *
     * @return an opaque memento containing the current state
     */
    fun getMemento(): StarMemento =
        StarMementoInternal(
            type = type,
            ageYears = ageYears,
            massTons = massTons,
        )

    /**
     * Restores this star's state from a previously captured
     * [StarMemento].
     *
     * @param memento the memento to restore from
     */
    fun setMemento(memento: StarMemento) {
        val state = memento as StarMementoInternal
        type = state.type
        ageYears = state.ageYears
        massTons = state.massTons
    }

    override fun toString(): String =
        "$type age: $ageYears years mass: $massTons tons"

    /**
     * Private memento implementation that stores the
     * [Star]'s internal state. Hidden from the caretaker
     * behind the [StarMemento] interface.
     */
    private data class StarMementoInternal(
        val type: StarType,
        val ageYears: Int,
        val massTons: Int,
    ) : StarMemento
}
