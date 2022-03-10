package com.test

//This is a Demo!! to ThisIsADemo

object CombinatorMethodFlatMap {

  def filterNonAlphabets(s: String): Option[String] =
    if(s != null)
      Some(s.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
    else None

  def capitalizeWords(s: String): Option[String] =
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

//  def camelCase1(s: String): Option[String] = {
//    val filteredAndCapitalized: Option[String] = filterNonAlphabets(s)
//      .map { filtered => capitalizeWords(filtered) }.flatten
//    filteredAndCapitalized
//    val filteredAndCapitalized:Option[String] = filterNonAlphabets(s)
//            .flatMap(filtered => capitalizeWords(filtered)).flatMap(capitalized => removeAllSpaces(capitalized))
//    filteredAndCapitalized
//  }



    def camelCase2(s: String): Option[String] =
        filterNonAlphabets(s)
          .flatMap { filtered =>
            capitalizeWords(filtered)
              .flatMap { capitalized =>
                removeAllSpaces(capitalized)
              }
          }

  def camelCase(str: String): Option[String] =
    for {
      filtered <- filterNonAlphabets(str)
      capitalized <- capitalizeWords(filtered)
      camelCased <- removeAllSpaces(capitalized)
    } yield  camelCased

  def main(args: Array[String]): Unit = {

    val str = "This is a Demo!!"
    println(camelCase(str))

//    val test2:Option[String]  = Some(str.filter(c => (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 32))
//      .flatMap(other => Some(other.toLowerCase()))
//      .flatMap(other =>Some(other.split(" ").map(token => token.capitalize).mkString))
//      .flatMap {other =>Some(other.replace(" ", ""))}
  }
}
