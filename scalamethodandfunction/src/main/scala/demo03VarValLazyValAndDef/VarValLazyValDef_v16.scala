package demo03VarValLazyValAndDef

object VarValLazyValDefv16 extends App {

  lazy val data = {
    println ("Array is initialized");
    Array("MSFT", "GOOG", "TM")
  }

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data.foreach(println)
}

