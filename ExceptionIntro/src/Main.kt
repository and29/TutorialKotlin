
fun main() {
    var card = CreditCard(50.0)
    try {
        card.pay(100.0)
    }catch (ex : CreditInsufficent){
        println(ex.message)
    }

}