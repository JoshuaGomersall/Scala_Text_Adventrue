package TextGame.ShopsAndItems

import TextGame.RandomAndEventCreation._

object CurrencyLogic {

  def main(args: Array[String]): Unit = {
    currencyGainingChecker(1,4300,13000)
  }

  def currencyGainingChecker (goldIn: Int ,silverIn: Int ,bronzeIn: Int) : List[Int] = {
    bronzeIn match {
      case x if x > 100 =>
        val bronzeUpdated = bronzeIn - 100
        val silverUpdated = silverIn + 10
        currencyGainingChecker(goldIn,silverUpdated,bronzeUpdated)
        sys.exit()
      case x if x >= 10 =>
        val bronzeUpdated = bronzeIn - 10
        val silverUpdated = silverIn + 1
        currencyGainingChecker(goldIn,silverUpdated,bronzeUpdated)
        sys.exit()
      case _ =>
    }
    silverIn match {
      case x if x > 100 =>
        val silverUpdated = silverIn - 100
        val goldUpdated = goldIn + 10
        currencyGainingChecker(goldUpdated,silverUpdated,bronzeIn)
        sys.exit()
      case x if x >= 10 =>
        val silverUpdated = silverIn - 10
        val goldUpdated = goldIn + 1
        currencyGainingChecker(goldUpdated ,silverUpdated ,bronzeIn)
        sys.exit()
      case _ =>
    }

    val newCurrency:List[Int] = List(goldIn,silverIn,bronzeIn)

    println(s"Gold   : ${newCurrency(0)} \nSilver : ${newCurrency(1)} \nBronze : ${newCurrency(2)}")
    newCurrency
  }
}
