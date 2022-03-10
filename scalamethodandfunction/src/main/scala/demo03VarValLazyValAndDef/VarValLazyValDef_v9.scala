package demo03VarValLazyValAndDef

object VarValLazyValDefv9 extends App {

  def stockPrice: Int = 14
  def volume: Int = 100

  def finalValue: Int = stockPrice * volume

  println(s"The final value is: $finalValue")
}

