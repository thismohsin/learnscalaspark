package demo21TailRecursion

import scala.annotation.tailrec

object TailRecursion2 extends App {

  def readFinanceData():Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  def rollingAverage(records: Vector[StockRecord], numDays: Int):Unit = {

    if (records.length < numDays) {
      throw new Exception("Error so we can see the stack trace")
    } else {
      val averageClose = records.map(_.close).take(numDays).sum / numDays

      println(s"Rolling average close for $numDays days " +
        s"date ${records.head.date}: $averageClose")

      val updatedRecords = records.drop(1)

      rollingAverage(updatedRecords, numDays)

      println("Random print statement on the last line of the function")
    }
  }

  rollingAverage(readFinanceData(), 30)
}


