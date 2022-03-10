package demo01ShowingEnvironmentSetup
import java.io.File

object Test01 extends App{

  trait FileOps {
    self: File =>
    def isTextFile : Boolean = true
    def isFile: Boolean = this.getName().endsWith("txt")

  }

//  val foofile = new File("") with FileOps
//
//  println(foofile.isTextFile)
//  println(foofile.isFile)

//  ### covariance and contravariance ##

//  List[+T]
//   Fruit < Apple -- covariance
//  List[-T]
//  Apple < Fruit -- contravariance
//  List[-T <: Fruit]
//  upperbound will accept subtype Apple
//  List[-T >: Apple]
//  lower bound will accept supertype Fruit
//  List[-T >: Apple <:Fruit]
//  accept supertype of apples only +  accept subtype of fruit only
//  trait Function[-T, +R] extends AnyRef{
//    def apply(p1: T):R
//  }
//  val i = (j : Int) => j + 1
//  //i.e,
//  new Function1[Int, Int]:{
//    def apply (p1:Int):Int
//  }


  // ## implicit ##
  trait Combiner[T]{
    def combine(a:T, b:T): T
  }
  object Combiner{
    implicit val intCombiner: Combiner[Int] = new Combiner[Int] {
      override def combine(a: Int, b: Int): Int = a+b
    }
    implicit  val stringCombiner: Combiner[String] = new Combiner[String] {
      override def combine(a: String, b: String): String = a+b .toString
    }
  }
  object CombinerOps{
    def combine[T](a:T, b:T)(implicit ev:Combiner[T]):T = ev.combine(a,b)

    //to support tuple (1,3).combine
    implicit class CombinerTuple[T](pair : Tuple2[T,T]){
      def combine(implicit ev: Combiner[T]):T = ev.combine(pair._1, pair._2)
    }
  }
  object CombineDemo {
    import CombinerOps._
    val combineInt = combine(1,4)
    val combineString = combine("a","b")
    val tuplesupport = (1,2).combine
  }

}
