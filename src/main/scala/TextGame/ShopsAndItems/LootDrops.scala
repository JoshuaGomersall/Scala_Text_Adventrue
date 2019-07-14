package TextGame.ShopsAndItems

import TextGame.RandomAndEventCreation._
import TextGame.ShopsAndItems.LootDrops.randomCurrency

object LootDrops {

  def main(args: Array[String]): Unit = {
    randomChecker
  }

  def randomChecker: List[Int] = {
    randomCurrency(Random.integerValue(350,0),Random.integerValue(50,-1))
    randomChecker
  }


  def randomCurrency(currencyType: Int,currencyAmount :Int): Unit = {
    Thread.sleep(180)
    val currencyTypes :List[String] = List("Crowns","Scroll","Sickle")
    println(s"You Got $currencyAmount ${currencyTypes(currencyType)}")
  }

  def randomItem(randomValue: Int): Unit = {
    val items :List[String] = List("Sword","Shield","Arrow","Crowns","")

  }
}
