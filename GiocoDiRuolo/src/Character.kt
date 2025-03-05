open class Character(
    val name: String,
    var health: Int,
    val attackPower: Int
) {
    fun attack(target: Character) {
        target.takeDamage(attackPower)
    }

    fun takeDamage(damage: Int) {
        health -= damage
        println("$name subisce $damage danni. Vita rimasta: $health")
    }

    fun isAlive(): Boolean = health > 0

    override fun toString(): String {
        return "$name health:$health "
    }
}