package com.test

import java.util.UUID
import java.util.concurrent.ForkJoinPool
//import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import scala.util.{Failure, Success, Try}

object ThreadEx {

  //####
  def threaded(t: =>Any):Thread= {
    val child = new Thread {
      override def run(): Unit = t
    }
    child.start()
    child
  }

  val t1 = threaded {
    println(1)
  }
  val t2 = threaded {
    println(2)
  }
  t1.join
  t2.join //main thread wait for these thread to finish

  //######

  // use global thread context or define urs
  //import scala.concurrent.ExecutionContext.Implicits.global
  implicit val threadpool : ForkJoinPool = new ForkJoinPool(2)
  implicit  val ec : ExecutionContextExecutor = ExecutionContext.fromExecutorService(threadpool)
  private var Users = Map[UUID, Object]()
  def createUser(user: String): Future[Either[Some[String], String]] = Future{
    Try(Users + ( UUID.randomUUID() -> user)).map(newUsers => Users = newUsers)match{
      case Failure(exception) => Left(Some("issue"))
      case Success(_) => Right(user)
    }
  }

  //###
  def insert(user:String)(implicit ec: ExecutionContext): Future[String]= Future{
    "String"
  }
  val createdUser: Future[String] = insert("works")

  createdUser.foreach( user => println(user))

  createdUser.andThen{
    case Success(user) => println(user) //step1
  }.andThen{
    case Success(user) =>println(user) //step2
  }

  createdUser.map{user => Right(user)}

  //## multiple future

//  encryptPassword(user) //1st Async
//    .flatMap {
//      eUser => insert(user) //2nd Async
//    }
// for {
//   first <- encryptPassword(user)
//   second <- insert(user)
//   _ <- Some("work")
// }yield {
// }
//}

  //zip is use to hold result and return tuple (result, status of thread)
// (encryptPassword(user)).zip(isUserUnique()).flatMap{ isuserunique: (User,Boolean) => val(pwd, isunique)=isuserunique ...}


    .recover{
      case e: Exception => Left(e.getMessage)
    }
}
