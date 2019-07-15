package TextGame.ShopsAndItems


object CurrencyLogic {

  def main(args: Array[String]): Unit = {
    val testingclass = currencyChecker(10,10,11)
    println(testingclass)
    println("Done" + testingclass)
  }

  @annotation.tailrec
  def currencyChecker(goldIn: Int, silverIn: Int, bronzeIn: Int,doneChecking :Boolean = false): List[Int] = {
    Thread.sleep(100)
    println(s"Gold : $goldIn ,Silver : $silverIn ,Bronze : $bronzeIn")

    var gold: Int = goldIn
    var silver: Int = silverIn
    var bronze: Int = bronzeIn

    silverIn match {
      case x if x < 0 && goldIn > 0 =>
        silver = silverIn + 10
        gold = goldIn - 1
      //currencyChecker(goldUpdated, silverUpdated, bronzeIn)

      case x if x >= 100 =>
        silver = silverIn - 100
        gold = goldIn + 10
      //currencyChecker(goldUpdated, silverUpdated, bronzeIn)

      case x if x >= 10 =>
        silver = silverIn - 10
        gold = goldIn + 1
      //currencyChecker(goldUpdated, silverUpdated, bronzeIn)

      case _ =>
    }
    bronzeIn match {
      case x if x < 0 && silverIn > 0 =>
        bronze = bronzeIn + 10
        silver = silver - 1
      currencyChecker(goldIn, silver, bronze)

      case x if x >= 100 =>
        bronze = bronzeIn - 100
        silver = silver + 10
      currencyChecker(goldIn, silver, bronze)

      case x if x >= 10 =>
        bronze = bronzeIn - 10
        silver = silverIn + 1
      currencyChecker(goldIn, silver, bronze)

      case _ if goldIn > 0 && silverIn > 0 & bronzeIn > 0 =>
        val newCurrency: List[Int] = List(gold, silver, bronze)
        println(s"Gold   : ${newCurrency(0)} \nSilver : ${newCurrency(1)} \nBronze : ${newCurrency(2)}")
        println(newCurrency.toString())
        //currencyChecker(goldIn,silverIn,bronzeIn)
        newCurrency
    }
  }
}