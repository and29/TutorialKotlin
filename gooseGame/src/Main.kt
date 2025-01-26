import java.util.Scanner
import kotlin.random.Random

fun main() {
    var nPlayers :Int?

    var input :String? = null
    while (input?.toIntOrNull() == null) {
        println("insert number of players")
        input = readlnOrNull()
    }
    nPlayers = input.toInt()
    val nGameCells = 30
    val positions = MutableList(nPlayers) {0}
    var diceValue :Int?
    val gameCell = MutableList(nGameCells) {Random.nextInt(3)}

    while (!positions.contains(nGameCells)) {
        for (i in 0..<nPlayers) {
            do {
                println("Player ${i+1} turn enter the dice value")
                diceValue = readlnOrNull()?.toIntOrNull()
                if (diceValue == null || diceValue !in 1..6) println("Insert a number between 1 and 6")
            }while (diceValue == null || diceValue !in 1..6)
            positions[i] = newPositionEvaluation(gameCell, positions[i], diceValue)
            positions.forEachIndexed { id, el -> println("player ${id + 1}: position $el") }
            if (positions[i] == gameCell.size) {
                println("player ${i+1} won!")
                break
            }else{
                printStatus(gameCell,positions)
            }
        }

    }
}

fun printStatus(gameCell: MutableList<Int>, positions: MutableList<Int>) {
    for((id,playerPosition) in positions.withIndex()) {
        print( "${id+1}: ")
        for (cell in 0..<gameCell.size) {
            if (cell == playerPosition) {
                print("X")
            }else{
                print(gameCell[cell])
            }
        }
        println()
    }

}


fun mapCell(type:Int) : ((Int) -> Int){
    when (type) {
        1 -> return { i -> i*2 }
        3 -> return { i -> i-3 }
    }
    return { i -> i }
}


fun newPositionEvaluation(gameCell:MutableList<Int>, position:Int, diceValue: Int): Int {
    val computeNewPosition = mapCell(gameCell[position])
    var newPosition = position + computeNewPosition(diceValue)
    if(newPosition > gameCell.size) {
        val remaining = newPosition - gameCell.size
        newPosition -= remaining

    }
    return newPosition
}
