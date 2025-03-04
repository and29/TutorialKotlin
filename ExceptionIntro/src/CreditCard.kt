class CreditCard(var balance: Double) {
    fun pay(amount: Double) {
        if (balance >= amount) {
            balance -= amount
        }
        throw CreditInsufficent()
    }
}