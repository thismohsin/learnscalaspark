package two
import java.util.UUID

class Customer(first: String, last: String, email: String) { // add final to seal a class from inheriting
  private val _id: UUID = UUID.randomUUID()
  private val _first = first
  private val _last = last
  private val _email = email

  def getId: UUID = _id
  def getFirst: String = _first
  def getLast: String = _last
  def getEmail: String = _email
}
class HackCustomer(first: String = "****", last: String="****", email: String="****") extends Customer(first, last, email) {}

trait Address {
  protected var _zip: Int
  protected var _street: String
  protected var _state: String

  def setZip(zip: Int): Unit
  def setStreet(street: String): Unit
  def setState(state: String): Unit
  def printAddress(): Unit = println(s"${_street}, ${_state}, ${_zip}")
}

trait SecretCodeGenerator {
  def getOTP: String = UUID.randomUUID().toString
}

class CustomerWithAddress(first: String, last: String, email: String) extends Customer(first, last, email)
  with Address with SecretCodeGenerator {
  override protected var _zip: Int = -1
  override protected var _street: String = ""
  override protected var _state: String = ""

  override def setZip(zip: Int): Unit = _zip = zip

  override def setStreet(street: String): Unit = _street = street

  override def setState(state: String): Unit = _state = state
}

class DepositBoxContainer extends SecretCodeGenerator

object EmailRunner extends App {
  val c1 = new CustomerWithAddress("Tony", "Stark", "t@stark.com")
  c1.setZip(95050)
  c1.setStreet("45 Fremont St")
  c1.setState("California")
  println(c1.getFirst, c1.getLast, c1.getEmail)
  c1.printAddress()
  println(c1.getOTP)

  val depositBoxContainer = new DepositBoxContainer
  println("DepositBoxContainer OTP: " + depositBoxContainer.getOTP)
}