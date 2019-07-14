package TextGame.RadnomAndEventCreation

import java.util.Calendar

object Random {

  def main(args: Array[String]): Unit = {
  }


  def integerValue(maxValue: Int): Int ={
    val now = Calendar.getInstance()
    val randomValueInt = now.get(Calendar.MILLISECOND)
    randomValueInt.toInt /maxValue - 5
  }
}
