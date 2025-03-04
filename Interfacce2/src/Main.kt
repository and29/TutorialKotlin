fun main() {
    val users = listOf(
        User("Alice", 30),
        User("Bob", 25),
        User("Charlie", 35)
    )

    val products = listOf(
        Product(101, "Laptop", 999.99),
        Product(102, "Mouse", 25.50),
        Product(103, "Keyboard", 45.99)
    )

    println("Users sorted by age:")
    println(users.sorted()) // Grazie a Comparable, possiamo usare sorted()

    println("\nProducts sorted by price:")
    println(products.sorted()) // Grazie a Comparable, possiamo usare sorted()
}