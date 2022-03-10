package com.test

object Test extends App {

  val l = List(1,2,3,4,5)

  println(l.map( x => x*2 ).toList)

  def f(x: Int) = if (x > 2) Some(x) else None
  println(l.map(x => f(x)))
  def g(v:Int) = List(v-1, v, v+1)
  println(l.map(x => g(x)))
  println(l.flatMap(x => g(x)))
  println(l.map(x => f(x)))
  println(l.flatMap(x => f(x)))

  val m = Map(1 -> 2, 2 -> 4, 3 -> 6)
  println(m)
  println(m.toList)
  val t = (1,2)
  println(t._1)
  println(t._2)
  //println(m.mapValues(v => v*2))
  //println( m.mapValues(v => f(v)))
  println(m.flatMap(e => List(e._2)))
  println(m.flatMap(e => List(e)))

  def h(k:Int, v:Int) = if (v > 2) Some(k->v) else None
  println(m.flatMap ( e => h(e._1,e._2) ))
  // m.flatMap ( (k,v) => h(k,v) )
  println(m.flatMap { case (k,v) => h(k,v) })

  println(m.filter( e => f(e._2) != None ))
  println(m.filter { case (k,v) => f(v) != None })
  println(m.filter { case (k,v) => f(v).isDefined })
}
