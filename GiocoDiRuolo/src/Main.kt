import kotlin.random.Random

fun main() {
    var name :String? = null
    while (name == null){
        println("inserisci il nome del tuo eroe")
        name = readLine()
    }
    val hero = Hero(name, Random.nextInt(20,30), Random.nextInt(5,15))
    val enemy = Enemy("Goblin", Random.nextInt(20,30), Random.nextInt(5,15))

    println("Benvenuto nel gioco! il tuo personagigo è $hero" +
            "Ti trovi di fronte a un ${enemy}.\n")

    while (hero.isAlive() && enemy.isAlive()) {
        println("\nChe cosa vuoi fare?")
        println("1. Attaccare")
        println("2. Difendersi")
        println("3. Fuggire")
        print("Scegli un'opzione: ")

        when (readLine()) {
            "1" -> {
                hero.attack(enemy)
                if (enemy.isAlive()) enemy.attack(hero)
            }
            "2" -> {
                val blocked = hero.defend(enemy)
            }
            "3" -> {
                println("Hai deciso di fuggire! Il gioco termina qui.")
                return
            }
            else -> println("Scelta non valida. Perdi un turno!")
        }

        if (!hero.isAlive()) {
            println("Sei stato sconfitto. Game Over!")
        } else if (!enemy.isAlive()) {
            println("Hai sconfitto il ${enemy.name}! Complimenti!")
        }
    }
}


