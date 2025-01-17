fun factorial(n: Int): Int {
    var result: Int = 1
    for(i in 1..n){
        result *= i
    }
    return result
}

fun compare(a: Int, b: Int): Int = if (a < b) a else b



fun main() {
    var c:Int = 5
    var lista = mutableListOf("one","two","three","four","five","six")

    var mapMarks = {a:Int ->
        {

        }
    }

    print("Factorial of $c is ${factorial(c)}")

    var array = arrayOf(2,5,-21,6,4,2,1,6,3,4)

    //array.sortWith(compareByDescending {(it, it2)-> compare(it, ) })
    array.forEach { println(it) }

    println(array.fold(0, { acc, b ->
        if(b>0) {acc + b} else acc}))
    println(array.sum())

    array.map


    for((i, element) in lista.withIndex()){
        println("$i $element")
    }


}