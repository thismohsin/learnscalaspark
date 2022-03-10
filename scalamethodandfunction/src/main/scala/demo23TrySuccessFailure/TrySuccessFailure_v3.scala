package demo23TrySuccessFailure

import java.io.{BufferedReader, FileReader}
import scala.util.Using

object TrySuccessFailure3 extends App {

  val lines: List[String] =
    Using.resource(new BufferedReader(new FileReader(
      "src/main/resources/dividendStocks.csv"))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }

  lines.foreach(println)
}
