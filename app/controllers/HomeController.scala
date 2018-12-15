package controllers

import javax.inject._
import play.Play
import play.api.mvc._
import scala.io
import models.Customer
import algorithm.ChurnUtil
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
    val c_Util =new ChurnUtil()
    val csv_path =Play.application().path().toString+"/public/churn_data/result.csv"
    Ok(views.html.index("Churn Prediction",c_Util.read_result_csv(50,csv_path)))
  }

  def downloadResult =Action{
    Ok.sendFile(
      content = new java.io.File(Play.application().path().toString+"/public/churn_data/result.csv"),
      inline = true)
  }


}
