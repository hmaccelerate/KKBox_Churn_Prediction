package algorithm


import play.Play
import scala.io
import models.Customer

/**
  * Created by hmaccelerate on 2018/12/1.
  */
class ChurnUtil {


  // build the is_discount feature
  def is_discount(plan_list_price: Int, actual_pay:Int):Int ={
    if (plan_list_price>actual_pay&&actual_pay!=0)
      return 1
    else
      return 0
  }

  // build the autorenew_&_not_cancel feature: the user is using autorenew and is not a cancelded user
  def is_autorenew_n_cancel(is_auto_renew:Int,is_cancel:Int):Int={
    if(is_auto_renew==1&&is_cancel==0)
      return 1
    else
      return 0
  }

  // build the notAutorenew&Cancel feature: the user is not using autorenew and is a cancelded user
  def is_n_autorenew_cancel(is_auto_renew:Int,is_cancel:Int):Int={
    if(is_auto_renew==0&&is_cancel==1)
      return 1
    else
      return 0
  }

  def read_result_csv(number_result:Int,path:String):List[Customer]={
    val bufferedSource = io.Source.fromFile(path)
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
