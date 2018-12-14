package test

/**
  * Created by hmaccelerate on 2018/12/14.
  */
import org.scalatest.FunSuite
import controllers.HomeController
import org.scalatest._
import collection.mutable.Stack
import algorithm.ChurnUtil

class ChurnTest extends FlatSpec with Matchers {

  "is_autorenew_n_cancel" should "return 0 or 1" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
    val cUtil = new ChurnUtil()
    cUtil.is_autorenew_n_cancel(1,0) should be (1)
    cUtil.is_autorenew_n_cancel(0,0) should be (0)
  }

}