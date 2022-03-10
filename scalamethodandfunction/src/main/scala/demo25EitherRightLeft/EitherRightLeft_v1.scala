package demo25EitherRightLeft

object EitherRightLeft1 extends App {

  def convertToFloat(someString: String): Either[String, Float] = {
    try {
      Right(someString.toFloat)
    } catch {
      case e:NumberFormatException =>
        Left("There was an error parsing the float: " + someString)
    }
  }

  val googStockPrices = List("1367.36", "asdf", "1360.66", "1394.20",
    "1393.33", "1404.31", "1419.82", "1429.73")

  println(googStockPrices.map(convertToFloat))
}

