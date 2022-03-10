package demo03VarValLazyValAndDef

object VarValLazyValDev4f extends App {
  var data = {println ("Array is initialized"); Array(
    "MSFT", "GOOG", "TM"
  )}

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data.foreach(println)

  println("---------------------")
  data = {println ("New Array is initialized"); Array("AAPL")}
  data.foreach(println)
}

