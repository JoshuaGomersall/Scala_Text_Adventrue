package TextGame.RadnomAndEventCreation

import java.util.Calendar

object Random {

  def main(args: Array[String]): Unit = {
  }


  def integerValue(maxValue: Int): Int ={
    val now = Calendar.getInstance()
    val randomValueInt = now.get(Calendar.MILLISECOND)
    println("New Random : " + {randomValueInt.toInt /maxValue - 10})
    randomValueInt.toInt /maxValue - 10
  }
}
