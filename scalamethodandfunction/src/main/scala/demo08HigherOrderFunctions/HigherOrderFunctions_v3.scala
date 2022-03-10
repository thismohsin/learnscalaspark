package demo08HigherOrderFunctions

object HigherOrderFunctions3 extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  val extractHighPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.high)
  }

  val extractOpenPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.open)
  }

  val extractClosePrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close)
  }

  val extractPriceDelta = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close - record.open)
  }

  val extractInfo = (records: Vector[StockRecord],
                     extractFunction: Vector[StockRecord] => Vector[(String, Float)]) => {
    extractFunction(records)
  }

  println("Open: " + extractInfo(records, extractOpenPrice))
  println("Close: " + extractInfo(records, extractClosePrice))
  println("Delta: " + extractInfo(records, extractPriceDelta))
}
