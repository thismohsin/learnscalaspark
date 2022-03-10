package demo06PartiallyAppliedFunction

object PartiallyAppliedFunctions6 extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceInRange(price: Double, lower: Double, upper: Double):Boolean =
    price >= lower && price <= upper

  val googStockPricesInRangeFunction =
    checkPriceInRange(_: Double, _:Double, 1410)

  val googStockPricesInRange =
    googStockPrices.filter((price) => googStockPricesInRangeFunction(price, 1390))

  println(googStockPricesInRange)
}
