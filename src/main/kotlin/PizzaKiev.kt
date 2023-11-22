class PizzaKiev(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink, CheckPhoto, Sauce{
    override var summaryCofeMoney = 0

    override var yesPhoto = 0
    override var summarySale = 0
    override var yesSauce = 0

    override var moneySauce = mutableMapOf(
        "mayo" to 0,
        "ketchup" to 0)
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
    override fun showCheckPhoto() {
        println("\nУ вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1"){
            yesPhoto++
            println("Вам будет скидка 50 рублей с покупки\n")
            summarySale += 50
        }
    }

    override fun sauceSale() {
        println("\nВыберите соус к пицце:")
        println("1. Майонез (100 рублей)\n2. Кетчуп (80 рублей)\n3. Никакой")
        val currentSauce: Pair<Int, String> = when (readln()){
            "1" -> (100 to "mayo")
            "2" -> (80 to "ketchup")
            else -> return
        }
        yesSauce++
        println("С вас ${currentSauce.first} рублей!\n")
        moneySauce[currentSauce.second] = moneySauce[currentSauce.second]!! + currentSauce.first
    }
    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Киеве")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Киеве")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Киеве")
    }

    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Киеве")
    }

    override fun getAdditionMoney(): Int {
        return summaryCofeMoney - summarySale + moneySauce.values.sum()
    }

    override fun getAdditionStatistics() {
        val total = neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        println("\nЧисло человек, показавших чек: ${yesPhoto}")
        println("Процент людей, показывающих чек: ${yesPhoto.toDouble() / total * 100}%")
        println("Процент людей, не показывающих чек: ${100 - (yesPhoto.toDouble() / total * 100)}%\n")

        println("Число человек, купивших кофе: ${pizzas.values.sum()}")
        println("Процент людей, покупающих кофе: ${pizzas.values.sum().toDouble() / total * 100}%")
        println("Процент людей, не покупающих кофе: ${100 - (pizzas.values.sum().toDouble() / total * 100)}%\n")

        println("Количество проданных соусов: ${yesSauce}")
        println("За майонез было выручено ${moneySauce["mayo"]}")
        println("За кетчуп было выручено ${moneySauce["ketchup"]}\n")

        println("К неаполитанской пицце купило кофе ${pizzas["neapolitan"]} человек (${pizzas["neapolitan"]!!.toDouble() / total * 100}%)")
        println("К римской пицце купило кофе ${pizzas["roman"]} человек (${pizzas["roman"]!!.toDouble() / total * 100}%)")
        println("К сицилийской пицце купило кофе ${pizzas["sicilian"]} человек (${pizzas["sicilian"]!!.toDouble() / total * 100}%)")
        println("К тирольской пицце купило кофе ${pizzas["tyrolean"]} человек (${pizzas["tyrolean"]!!.toDouble() / total * 100}%)")
        println("Чаще всего кофе покупают к ${pizzas.maxBy { it.value }.key};" +
                " Количество купленных кофе: ${pizzas.maxBy { it.value }.value}\n")
    }
}