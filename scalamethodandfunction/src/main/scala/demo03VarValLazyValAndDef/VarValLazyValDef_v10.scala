package demo03VarValLazyValAndDef

object VarValLazyValDefv10 extends App {

  def stockPrice: Int = 14
  def volume: Int = 100

  // This will throw an error
  //-- def finalValue: Int = stockPrice * volume

  // This will fix the error
  def finalValue: String = (stockPrice * volume).toString

  println(s"The final value is: $finalValue")
}

