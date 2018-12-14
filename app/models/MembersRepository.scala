package models


import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

//@javax.inject.Singleton
//class MembersRepository @Inject()(dbapi: DBApi)(implicit ec: DatabaseExecutionContext){
//
//  private val db = dbapi.database("default")
//
//  def findById(id: Long): Future[Option[Computer]] = Future {
//    db.withConnection { implicit connection =>
//      SQL"select * from computer where id = $id".as(simple.singleOpt)
//    }
//  }(ec)
//
//}
