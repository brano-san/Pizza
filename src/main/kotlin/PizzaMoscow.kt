import java.util.function.IntToDoubleFunction

class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto{
    override var yesCount = 0
    override var noCount = 0
    override var checkCount = 0
    override var summarySale = 0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1"){
            println("Вам будет скидка 50 рублей с покупки")
            checkCount++
            summarySale += 50
            yesCount++
        } else {
            noCount++
        }
    }
    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }
    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    override fun getAdditionMoney(): Int {
        return -summarySale
    }

    override fun getAdditionStatistics() {
        println("Процент людей, показывающих чек: ${yesCount.toDouble() / (yesCount + noCount) * 100.0}")
    }
}