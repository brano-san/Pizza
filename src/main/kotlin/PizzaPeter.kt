class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink{
    override var yesCount = 0
    override var noCount = 0
    override var cofeCount = 0
    override var summaryCofeMoney = 0

    override fun drinkSale() {
        println("Вы будете пить кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1"){
            println("С вас 200 рублей")
            cofeCount++
            summaryCofeMoney += 200
            yesCount++
        } else{
            noCount++
        }
    }
    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }
    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    override fun getAdditionMoney(): Int {
        return summaryCofeMoney
    }

    override fun getAdditionStatistics() {
        println("Процент людей, покупающих кофе: ${yesCount.toDouble() / (yesCount + noCount) * 100}")
    }
}