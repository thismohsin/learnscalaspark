package demo03VarValLazyValAndDef

object VarValLazyValDefv1 extends App {

  var stockPrice = 14
  var volume = 100

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}

