package demo03VarValLazyValAndDef

object VarValLazyValDefv3 extends App {
  var data = {println ("Array is initialized"); Array(
    "MSFT", "GOOG", "TM"
  )}

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data.foreach(println)
}

