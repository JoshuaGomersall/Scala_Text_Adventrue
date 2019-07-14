package TextGame.ShopsAndItems



object CurrencyLogic {

  val checkDone = false

  def main(args: Array[String]): Unit = {
    val test :List[Int] = currencyChecker(10,-20,300)
    println(test)
  }

  def currencyChecker(goldIn: Int, silverIn: Int, bronzeIn: Int,doneChecking :Boolean = false): List[Int] = {
    Thread.sleep(200)
    println(s"Gold : $goldIn ,Silver : $silverIn ,Bronze : $bronzeIn")
    silverIn match {
      case x if x < 0 && goldIn > 0 =>
        val silverUpdated = silverIn + 10
        val goldUpdated = goldIn - 1
        currencyChecker(goldUpdated, silverUpdated, bronzeIn)
        sys.exit()
      case x if x > 100 =>
        val silverUpdated = silverIn - 100
        val goldUpdated = goldIn + 10
        currencyChecker(goldUpdated, silverUpdated, bronzeIn)
        sys.exit()
      case x if x >= 10 =>
        val silverUpdated = silverIn - 10
        val goldUpdated = goldIn + 1
        currencyChecker(goldUpdated, silverUpdated, bronzeIn)
        sys.exit()
      case _ =>
    }
    bronzeIn match {
      case x if x < 0 && silverIn > 0 =>
        val bronzeUpdated = bronzeIn + 10
        val silverUpdated = silverIn - 1
        currencyChecker(goldIn, silverUpdated, bronzeUpdated)
        sys.exit()
      case x if x > 100 =>
        val bronzeUpdated = bronzeIn - 100
        val silverUpdated = silverIn + 10
        currencyChecker(goldIn, silverUpdated, bronzeUpdated)
       sys.exit()
      case x if x >= 10 =>
        val bronzeUpdated = bronzeIn - 10
        val silverUpdated = silverIn + 1
        currencyChecker(goldIn, silverUpdated, bronzeUpdated)
        sys.exit()
      case _ =>
    }
    if (goldIn > 0 && silverIn > 0 & bronzeIn > 0) {
      val newCurrency: List[Int] = List(goldIn, silverIn, bronzeIn)
      println(s"Gold   : ${newCurrency(0)} \nSilver : ${newCurrency(1)} \nBronze : ${newCurrency(2)}")
      println(newCurrency.toString())
      newCurrency
    }
    List(goldIn,silverIn,bronzeIn)
  }
}