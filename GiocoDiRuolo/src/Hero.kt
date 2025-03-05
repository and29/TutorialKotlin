import kotlin.random.Random

class Hero(name: String,
           health: Int,
           attackPower: Int) : Character(name, health, attackPower)
{
    fun defend(enemy: Enemy): Boolean {
        val success = Random.nextBoolean()

        if (success) {
            val damage = attackPower / 2
            println("$name si difende dall'attacco di ${enemy.name} e contrattacca infliggendo $damage danni!")
            enemy.takeDamage(damage)
        } else {
            val damage = enemy.attackPower / 2
            println("$name prova a difendersi, ma subisce comunque $damage danni ridotti.")
            takeDamage(damage)
        }
        return success
    }
}

