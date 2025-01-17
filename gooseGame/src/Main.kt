import kotlin.random.Random

fun main() {
    var nPlayers :Int? = null
    do {
        println("insert number of players")
        nPlayers = readlnOrNull()?.toInt()
    }while (nPlayers == null)
    val nGameCells = 50
    var positions = MutableList(nPlayers) {0}
    var diceValue :Int?
    val gameCell = MutableList(nGameCells) {Random.nextInt(100).rem(3)}
    gameCell.forEach( {println(it)})
    while (!positions.contains(nGameCells)) {
        for (i in 0 until nPlayers) {
            do {
                println("player ${i+1} turn enter the dice value")
                diceValue = readlnOrNull()?.toInt()
            }while (diceValue == null || diceValue !in 1..6)
            positions[i] = newPositionEvaluation(gameCell, positions[i], diceValue)
            positions.forEachIndexed({i,el ->println("player ${i+1}: position $el")})
        }

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
    var computeNewPosition = mapCell(gameCell[position])
    return computeNewPosition(diceValue)
}
