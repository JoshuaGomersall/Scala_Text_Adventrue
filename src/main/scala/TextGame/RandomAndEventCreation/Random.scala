package TextGame.RandomAndEventCreation

import java.util.Calendar

object Random {

  def main(args: Array[String]): Unit = {
  }


  def integerValue(maxValue: Int ,minusValue :Int = 10): Int ={
    val now = Calendar.getInstance()
    val randomValueInt = now.get(Calendar.MILLISECOND)
    randomValueInt.toInt /maxValue - minusValue
  }
}
