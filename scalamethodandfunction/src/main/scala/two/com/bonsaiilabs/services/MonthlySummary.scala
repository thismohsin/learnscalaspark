package two.com.bonsaiilabs.services

import two.com.bonsaiilabs.entities.{AppUser, Budget, Transaction, sum}

case class MonthlySummary(val budget: Budget,
                          val ts: Array[Transaction]) {
  val userId: String = AppUser("Nick", "Jones").getId
  val total: Int = sum(2, 3)
}
