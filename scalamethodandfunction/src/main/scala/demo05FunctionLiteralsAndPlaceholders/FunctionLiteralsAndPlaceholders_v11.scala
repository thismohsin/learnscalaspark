package demo05FunctionLiteralsAndPlaceholders

object FunctionLiteralsAndPlaceholders11 extends App {

  val stockTickersInLowercase = List("goog", "ps", "tsla", "aapl", "msft")

  val stockTickers = stockTickersInLowercase.map(_.toUpperCase)

  println(stockTickers)
}
