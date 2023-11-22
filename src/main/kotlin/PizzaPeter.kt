class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink{
    override var summaryCofeMoney = 0
    override var pizzas = mutableMapOf(
        "neapolitan" to 0,
        "roman" to 0,
        "sicilian" to 0,
        "tyrolean" to 0)

    override fun drinkSale(pizzaName: String) {
        println("\nВы будете пить кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1"){
            println("С вас 200 рублей\n")
            summaryCofeMoney += 200
            pizzas[pizzaName] = pizzas[pizzaName]!! + 1
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
        val total = neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        println("\nПроцент людей, покупающих кофе: ${pizzas.values.sum().toDouble() / total * 100}%")
        println("Процент людей, не покупающих кофе: ${100 - (pizzas.values.sum().toDouble() / total * 100)}%\n")

        println("К неаполитанской пицце купило кофе ${pizzas["neapolitan"]} человек (${pizzas["neapolitan"]!!.toDouble() / total * 100}%)")
        println("К римской пицце купило кофе ${pizzas["roman"]} человек (${pizzas["roman"]!!.toDouble() / total * 100}%)")
        println("К сицилийской пицце купило кофе ${pizzas["sicilian"]} человек (${pizzas["sicilian"]!!.toDouble() / total * 100}%)")
        println("К тирольской пицце купило кофе ${pizzas["tyrolean"]} человек (${pizzas["tyrolean"]!!.toDouble() / total * 100}%)")
        println("Чаще всего кофе покупают к ${pizzas.maxBy { it.value }}\n")
    }
}