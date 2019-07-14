package TextGame.RadnomAndEventCreation

import java.util.Calendar

object Random {

  def main(args: Array[String]): Unit = {
  }


  def integerValue(maxValue: Int ,minusValue :Int = 10): Int ={
    val now = Calendar.getInstance()
    val randomValueInt = now.get(Calendar.MILLISECOND)
    println("New Random : " + {randomValueInt.toInt /maxValue - minusValue})
    randomValueInt.toInt /maxValue - minusValue
  }
}
