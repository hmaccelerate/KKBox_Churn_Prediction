package test

/**
  * Created by hmaccelerate on 2018/12/14.
  */
import org.scalatest._
import algorithm.ChurnUtil
class ChurnTest extends FlatSpec with Matchers {

  "is_discount" should "return 0 and 1" in {
      val cUtil = new ChurnUtil()
     cUtil.is_discount(98,50) should be (1)
     cUtil.is_discount(38,50) should be (0)
     cUtil.is_discount(38,0) should be (0)
  }

  "is_autorenew_n_cancel" should "return 0 and 1" in {
    val cUtil = new ChurnUtil()
    cUtil.is_autorenew_n_cancel(1,0) should be (1)
    cUtil.is_autorenew_n_cancel(1,1) should be (0)
    cUtil.is_autorenew_n_cancel(0,0) should be (0)
    cUtil.is_autorenew_n_cancel(0,1) should be (0)

  }

  "is_n_autorenew_cancel" should "return 0 and 1" in {
    val cUtil = new ChurnUtil()
    cUtil.is_n_autorenew_cancel(0,1) should be (1)
    cUtil.is_n_autorenew_cancel(0,0) should be (0)
    cUtil.is_n_autorenew_cancel(1,1) should be (0)
    cUtil.is_n_autorenew_cancel(1,0) should be (0)

  }


}
