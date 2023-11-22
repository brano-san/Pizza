interface Drink {
    abstract var summaryCofeMoney: Int
    abstract var pizzas: MutableMap<String, Int>
    abstract fun drinkSale(pizzaName: String)
}