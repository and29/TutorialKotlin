import kotlin.random.Random

fun main() {
    var nPlayers :Int?
    do {
        println("insert number of players")
        nPlayers = readlnOrNull()?.toInt()
    }while (nPlayers == null)
    val nGameCells = 30
    val positions = MutableList(nPlayers) {0}
    var diceValue :Int?
    val gameCell = MutableList(nGameCells) {Random.nextInt(100).rem(3)}
    while (!positions.contains(nGameCells)) {
        for (i in 0 until nPlayers) {
            do {
                println("player ${i+1} turn enter the dice value")
                diceValue = readlnOrNull()?.toInt()
            }while (diceValue == null || diceValue !in 1..6)
            positions[i] = newPositionEvaluation(gameCell, positions[i], diceValue)
            positions.forEachIndexed({id,el ->println("player ${id+1}: position $el")})
            if (positions[i] == gameCell.size) {
                println("player ${i} won!")
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
        for (cell in 0 until gameCell.size) {
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
