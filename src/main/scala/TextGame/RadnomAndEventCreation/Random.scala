package TextGame.RadnomAndEventCreation

object Random {

  def integerValue(maxValue: Int): Int ={
    scala.util.Random.nextInt(maxValue -5)
  }
}
