package demo06PartiallyAppliedFunction

object PartiallyAppliedFunctions4 extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double):Boolean = price > 1400

  val checkPricesGreaterThan1400Function = checkPriceGreaterThan1400 _

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter(checkPricesGreaterThan1400Function)

  println(googStockPricesGreaterThan1400)
}
