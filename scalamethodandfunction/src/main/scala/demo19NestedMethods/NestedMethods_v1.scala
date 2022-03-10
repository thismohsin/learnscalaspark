package demo19NestedMethods

object NestedMethods1 extends App {

  def readFinanceData():Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  private val data = readFinanceData()

  def printRecords(ticker:String):Unit = {

    println("Date       | Ticker | Close")

    def printRecords():Unit = {
      for (row <- data.filter(_.ticker == ticker)) {

        println(s"${row.date} | ${row.ticker}    | ${row.close}")
      }
    }

    printRecords()
  }

  printRecords("BNS")
}


