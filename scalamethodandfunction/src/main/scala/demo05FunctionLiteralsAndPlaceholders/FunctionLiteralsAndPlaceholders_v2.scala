package demo05FunctionLiteralsAndPlaceholders

object FunctionLiteralsAndPlaceholders2 extends App {

  var multiplyBy = (x: Int) => x * 100

  println(multiplyBy(3))

  println(multiplyBy(7))
}
