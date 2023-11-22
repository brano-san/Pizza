abstract class PizzaCity(
    private val neapolitanPizzaPrice: Double, private val romanPizzaPrice: Double,
    private val sicilianPizzaPrice: Double, private val tyroleanPizzaPrice: Double
){
    protected var neapolitanPizzaCount = 0
    protected var romanPizzaCount = 0
    protected var sicilianPizzaCount = 0
    protected var tyroleanPizzaCount = 0

    private var money = 0.0
    public abstract fun neapolitanPizzaSale()
    public abstract fun romanPizzaSale()
    public abstract fun sicilianPizzaSale()
    public abstract fun tyroleanPizzaSale()
    protected abstract fun getAdditionMoney() : Int
    protected abstract fun getAdditionStatistics()

    fun showStatistics(){
        println("\nПродано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
        getAdditionStatistics()

        money = sicilianPizzaCount * sicilianPizzaPrice +
                neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice

        println("Всего заработано денег: ${money + getAdditionMoney()}\n")
    }
}