package demo22TryCatchFinally

import scala.io.Source

object TryCatchFinally1 extends App {

  val sourcePath = Source.fromFile("src/main/resources/dividendStocks.csv")

  println("Reading file completed")

  val lines = sourcePath.getLines.toList
  lines.foreach(println)

  println("Displaying lines completed")
}
