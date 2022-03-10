package two.com.bonsaiilabs.entities

case class User(val first: String, last: String) {
  private[bonsaiilabs] def getId: String = ???
}
