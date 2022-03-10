package demo22TryCatchFinally

import scala.io.{BufferedSource, Source}
import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object TryCatchFinally8 extends App {

  def getLinesFromFile(filename:String): List[String] = {
    var sourcePath:BufferedSource = null

    try {
      sourcePath = Source.fromFile(filename)

      println("Reading file completed")

      sourcePath.getLines.toList
    } catch {
      case ex:FileNotFoundException => {
        println("File not found")
        List()
      }
      case ex:IOException => {
        println("Input/Output Exception")
        List()
      }
    } finally {
      println("Close file if it has been opened")
      if (sourcePath != null) {
        println("Closing file")
        sourcePath.close()
      }
    }
  }

  val lines = getLinesFromFile("src/main/resources/dividendStockss.csv")

  println("------Displaying lines")
  lines.foreach(println)
}
