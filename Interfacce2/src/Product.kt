data class Product(val id: Int, val name: String, val price: Double) : Comparable<Product> {
    override fun compareTo(other: Product): Int {
        return this.price.compareTo(other.price) // Ordinamento per prezzo crescente
    }
}