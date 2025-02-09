import kotlin.math.pow

//fun distance(point :MutableList<Double>) : Double = point.fold(0.0){ acc, i -> acc + i.pow(point.size) }.pow(0.5)
fun distance(point :MutableList<Double>) : Double {
    return point.fold(0.0){ acc, i -> acc + i.pow(point.size) }.pow(0.5)

}
fun main() {

    var puntoPiano = mutableListOf(3.5,5.0)
    puntoPiano.map { it * it }.sum()


    println(distance(puntoPiano))


    var frase = "Hallo World!"
    frase = frase.filter { it != ' ' }
    println(frase)
}