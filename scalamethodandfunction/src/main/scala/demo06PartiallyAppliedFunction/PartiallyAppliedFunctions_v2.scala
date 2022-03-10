package demo06PartiallyAppliedFunction

object PartiallyAppliedFunctions2 extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double):Boolean = price > 1400

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter(checkPriceGreaterThan1400 _)

  println(googStockPricesGreaterThan1400)
}
