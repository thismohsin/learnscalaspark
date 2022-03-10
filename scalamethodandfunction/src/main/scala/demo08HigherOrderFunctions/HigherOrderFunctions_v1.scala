package demo08HigherOrderFunctions

object HigherOrderFunctions1 extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("/Users/i509335/project/begin-scala/scalamethodandfunction/src/main/scala/demo08HigherOrderFunctions/StockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  println(records.getClass)

  for (record <- records) {
    println(record)
  }

}
