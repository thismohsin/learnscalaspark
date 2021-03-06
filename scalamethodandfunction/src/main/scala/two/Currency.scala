package two
object Currency {
  private val conversionTable: Map[String, Double] = Map("CAD" -> 1 / 1.30, "NZD" -> 1 / 1.50)
  private def getCostInUsd(code: String, amount: Double): Double = {
    code match {
      case "USD" => amount
      case "NZD" => amount * conversionTable("NZD")
      case "CAD" => amount * conversionTable("CAD")
      case _ => throw new IllegalArgumentException(s"No conversion available for ${code}")
    }
  }
  def apply(code: String, amount: Double) = new Currency(code, amount, getCostInUsd(code, amount))
  def createUSD(amount: Double): Currency = Currency("USD", amount)
  def createNZD(amount: Double): Currency = Currency("NZD", amount)
  def createCAD(amount: Double): Currency = Currency("CAD", amount)
  implicit def string2Currency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val requestedAmount: Double = value.toDouble
    Currency(code, requestedAmount)
  }
}

class Currency(code: String, amount: Double, inUSD: Double) {
  private val _code = code
  private val _amount = amount
  private val _inUSD: Double = inUSD

  override def toString: String = s"${_code} ${_amount} = USD ${_inUSD}"
}

object CurrencyRunner extends App {
  import Currency.string2Currency
  val nzd2: Currency = "NZD 25"
  println(nzd2)

  val cad2: Currency = "CAD 30"
  println(cad2)
}