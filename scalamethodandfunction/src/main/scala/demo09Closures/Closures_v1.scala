package demo09Closures

object Closures1 extends App {

  def readFinanceData():Vector[StockRecord] = {
    val source = io.Source.fromFile("/Users/i509335/project/begin-scala/scalamethodandfunction/src/main/scala/demo09Closures/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  val getDecisionMakerFunction = (records: Vector[StockRecord], date: String) => {

    val currDate = date
    val currRecords = records

    val makeDecision = (percentDelta: Float) => {
      val filteredRecords = currRecords.filter(_.date == currDate)
      assert(filteredRecords.length == 1)

      val record = filteredRecords.head

      val percentageMove = ((record.close - record.open) / record.open) * 100

      if (percentageMove > percentDelta) {
        println(s"Buy based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else if (percentageMove < -percentDelta){
        println(s"Sell based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else {
        println(s"No call based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      }
    }

    makeDecision
  }

  println("-----------------------")
  val decisionMaker1 = getDecisionMakerFunction(readFinanceData(), "2020-05-15")

  decisionMaker1(2)

//  println("-----------------------")
//  val decisionMaker2 = getDecisionMakerFunction(readFinanceData(), "2020-03-18")
//
//  decisionMaker2(2)
}


