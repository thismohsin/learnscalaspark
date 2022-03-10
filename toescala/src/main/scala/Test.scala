package com.test


//This is a Demo!! to ThisIsADemo

object CombinatorMethodFlatMap {

  def filterNonAlphabets(s: String): Option[String] =
    if(s != null)
      Some(s.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
    else None

  def capitalizeWords(s: String): Option[String] =
    println("###" + s)
    if(s != null)
      Some(
        s.split(" ")
          .map(token => token.capitalize)
          .mkString
      )
    else None

  def removeAllSpaces(s: String): Option[String] =
    if(s != null)
      Some(s.replace(" ", ""))
    else None

  def camelCase(s: String): Option[String] = {
//    val filteredAndCapitalized: Option[String] = filterNonAlphabets(s)
//      .map { filtered => capitalizeWords(filtered) }.flatten
//    filteredAndCapitalized
    val filteredAndCapitalized:Option[String] = filterNonAlphabets(s)
      .flatMap(filtered => capitalizeWords(filtered))
      .flatMap(capitalized => removeAllSpaces(capitalized))
    filteredAndCapitalized
  }



//    def camelCase2(s: String): Option[String] =
//      filterNonAlphabets(s)
//        .flatMap { filtered =>
//          capitalizeWords(filtered)
//            .flatMap { capitalized =>
//              removeAllSpaces(capitalized)
//            }
//        }

//  def camelCase(str: String): Option[String] =
//    for {
//      filtered <- filterNonAlphabets(str)
//      capitalized <- capitalizeWords(filtered)
//      camelCased <- removeAllSpaces(capitalized)
//    } yield  camelCased


  def stepone(): Unit = {
  var  str = "This is a Demo!!"
  var test1 = str.map(str => str.toUpper)
  //println(test1)

  val test2:Option[String]  = Some(str.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
    .flatMap(other => Some(other.toLowerCase()))
    .flatMap(other =>Some(other.split(" ").map(token => token.capitalize).mkString))
    .flatMap {other =>Some(other.replace(" ", ""))}
  //print(test2)

  val test3: Option[String] = Some(str.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
    .map(filtered =>  filtered.toLowerCase())
  //.map { filtered => capitalizeWords(filtered) }

  println(test3)
  println(test3.mkString)


  val test4: Option[String] = Some(str.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
    .map { filtered =>  Some(filtered.toLowerCase()) }.flatten

  println(test4)
  println(test4.mkString)

  //println(camelCase(str))
}



  def main(args: Array[String]): Unit = {

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
}

