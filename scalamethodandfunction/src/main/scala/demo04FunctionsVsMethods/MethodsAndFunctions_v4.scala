package demo04FunctionsVsMethods

object MethodsAndFunctionsv4 extends App {

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def getNumRowsMethod: Int = data.length

  val getNumRowsFunction = () => data.length

  println(getNumRowsMethod.getClass)
  println(getNumRowsFunction.getClass)
}
