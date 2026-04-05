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
     * The star's current state as an opaque [StarMemento].
     *
     * Reading captures a snapshot; writing restores a
     * previously captured snapshot.
     */
    var memento: StarMemento
        get() = StarSnapshot(
            type = type,
            ageYears = ageYears,
            massTons = massTons,
        )
        set(value) {
            val state = value as StarSnapshot
            type = state.type
            ageYears = state.ageYears
            massTons = state.massTons
        }

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

    override fun toString(): String =
        "$type age: $ageYears years mass: $massTons tons"

    /**
     * Private memento implementation that stores the
     * [Star]'s internal state. Hidden from the caretaker
     * behind the [StarMemento] interface.
     */
    private data class StarSnapshot(
        val type: StarType,
        val ageYears: Int,
        val massTons: Int,
    ) : StarMemento
}
