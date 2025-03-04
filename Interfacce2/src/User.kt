data class User(val name: String, val age: Int) : Comparable<User> {
    override fun compareTo(other: User): Int {
        return this.age - other.age // Ordinamento per età crescente
    }
}
