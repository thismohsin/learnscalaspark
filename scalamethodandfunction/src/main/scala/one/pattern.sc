

val aTuple = ("USD", 100)
println(aTuple._1)

aTuple match {
  case (currency, amount) if currency == "USD" => println("USD " + amount)
  case (currency, amount) if currency == "NZD" => println("USD " + amount * (1/1.50))
}

var amount = 5000
 var result: String = amount match{
   case a if a==50 => "bill is 50"
   case a if a==100 => "bill is 100"
   case a => "the amount is " + a
 }
abstract class Currency

case class USD() extends Currency

val currency : Currency = USD()

currency match {
  case u : USD => println("USD")
  case _ => println("other")
}

val anArray = Array(100, 200, 200)

anArray match {
  case Array (first,second, third) => println("third :" + third)
  case Array (_,_, third) => println("third :" + third)
}

