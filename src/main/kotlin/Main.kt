import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val pizzaPeter = PizzaPeter(
        175.0, 241.5,
        167.5, 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.0, 250.5,
        180.5, 240.0
    )
    val pizzaKiev = PizzaKiev(
        200.0, 250.0,
        180.0, 240.5
    )

    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Киев\n\n0. Выход из программы")

        val currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaKiev
            "0" -> break
            else -> {
                println("Ошибка")
                continue
            }
        }
        println("Выберите пиццу:")
        println("1. Неополитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity, "neapolitan")
        }
        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity, "roman")
        }
        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity, "sicilian")
        }
        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity, "tyrolean")
        }
        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("Ошибка")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity, pizzaName: String) {
    when (currentPizzaCity){
        is PizzaKiev -> {
            currentPizzaCity.showCheckPhoto()
            currentPizzaCity.drinkSale(pizzaName)
            currentPizzaCity.sauceSale()
        }
        is PizzaMoscow -> currentPizzaCity.showCheckPhoto()
        is PizzaPeter -> currentPizzaCity.drinkSale(pizzaName)
    }
}