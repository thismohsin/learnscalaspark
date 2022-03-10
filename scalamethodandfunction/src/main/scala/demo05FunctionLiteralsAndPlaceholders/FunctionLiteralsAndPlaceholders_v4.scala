package demo05FunctionLiteralsAndPlaceholders

object FunctionLiteralsAndPlaceholders4 extends App {

  var multiplyBy = (x: Int) => x * 100

  println(multiplyBy(3))

  multiplyBy = (x: Int) => x * 1000

  println(multiplyBy(3))
}
