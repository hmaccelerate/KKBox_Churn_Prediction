package controllers

import javax.inject._
import play.Play
import play.api.mvc._
import scala.io
import models.Customer
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Churn Prediction",read_result_csv(50)))
  }

  def downloadResult =Action{
    Ok.sendFile(
      content = new java.io.File(Play.application().path().toString+"/public/churn_data/result.csv"),
      inline = true)
  }




  def read_result_csv(number_result:Int):List[Customer]={
    val bufferedSource = io.Source.fromFile(Play.application().path().toString+"/public/churn_data/result.csv")
    val buf = scala.collection.mutable.ListBuffer.empty[Customer]
    try{
      for (line <- bufferedSource.getLines.take(number_result)) {
        val cols = line.split(",").map(_.trim)
        buf +=Customer(cols(0),cols(1),cols(8),cols(9),cols(13),cols(14),cols(25))
      }
    }catch {
      case e:Exception=> print(e)
    }
     buf.toList
  }

}
