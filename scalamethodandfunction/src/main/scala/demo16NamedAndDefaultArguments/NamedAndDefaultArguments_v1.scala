package demo16NamedAndDefaultArguments

object NamedAndDefaultArguments1 extends App {
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

  def getStockPriceDetails(date: String, ticker: String, priceType:String):
      (String, String, Float) = {

    println(s"Accessing records for ${date}")
    var filteredRecords = records.filter(_.date == date)

    println(s"Accessing records for ${ticker}")
    filteredRecords = filteredRecords.filter(_.ticker == ticker)

    val record = filteredRecords(0)

    println(s"Accessing price type ${priceType}")
    val price = priceType match {
      case "open" => record.open
      case "close" => record.close
      case "high" => record.high
      case "low" => record.low
    }

    (record.date, record.ticker, price)
  }

//  println(getStockPriceDetails("12-06-2020", "BNS", "open"))

//  println(getStockPriceDetails("BNS", "open", "BNS"))

//  println(getStockPriceDetails(date = "12-06-2020", ticker = "BNS", priceType = "open"))

//  println(getStockPriceDetails(priceType = "open", date = "12-06-2020", ticker = "BNS"))

//  println(getStockPriceDetails("12-06-2020", ticker = "BNS", priceType = "open"))

//  println(getStockPriceDetails("12-06-2020", priceType = "open", ticker = "BNS"))

//  println(getStockPriceDetails(date = "12-06-2020", priceType = "open", tocker = "BNS"))
}


