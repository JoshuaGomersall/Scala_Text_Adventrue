package TextGame.ShopsAndItems

object CurrencyLogic {

  def main(args: Array[String]): Unit = {
    val testingclass :List[Int] = currencyCheckerBronze(List(19, -100, -100))
    val testingclass2 :List[Int] = currencyCheckerSilver(testingclass)
    println("Done" + testingclass2)

    if (testingclass2.contains("-")){
      println("Too Poor")
    }
  }

  @annotation.tailrec
  def currencyCheckerSilver(currency :List[Int]): List[Int] = {
    Thread.sleep(100)
    println(s"Gold : ${currency(0)} ,Silver : ${currency(1)} ,Bronze : ${currency(2)}")

    currency(1) match {
      case x if x < 0 && currency(0) > 0 =>
    val silverUpdated = currency(1) + 10
    val goldUpdated = currency(0) - 1
    currencyCheckerSilver(List(goldUpdated, silverUpdated, currency(2)))
    case x if x >= 10000 =>
      val silverUpdated = currency(1) - 10000
      val goldUpdated = currency(0) + 1000
      currencyCheckerSilver(List(goldUpdated, silverUpdated, currency(2)))
    case x if x >= 1000 =>
      val silverUpdated = currency(1) - 1000
      val goldUpdated = currency(0) + 100
      currencyCheckerSilver(List(goldUpdated, silverUpdated, currency(2)))
    case x if x >= 100 =>
    val silverUpdated = currency(1) - 100
    val goldUpdated = currency(0) + 10
    currencyCheckerSilver(List(goldUpdated, silverUpdated, currency(2)))
    case x if x >= 10 =>
      val silverUpdated = currency(1) - 10
      val goldUpdated = currency(0) + 1
      currencyCheckerSilver(List(goldUpdated, silverUpdated, currency(2)))
    case _ => currency
    }
  }

  @annotation.tailrec
  def currencyCheckerBronze(currency :List[Int]): List[Int] = {
    Thread.sleep(100)
    println(s"Gold : ${currency(0)} ,Silver : ${currency(1)} ,Bronze : ${currency(2)}")

    currency(2) match {
      case x if x < 0 && currency(0) > 0 =>
        val bronzeUpdated = currency(2) + 100
        val goldUpdated = currency(0) - 1
        currencyCheckerBronze(List(goldUpdated, currency(1) , bronzeUpdated))
      case x if x < 0 && currency(1) > 10 =>
        val bronzeUpdated = currency(2) + 100
        val silverUpdated = currency(1) - 10
        currencyCheckerBronze(List(currency(0), silverUpdated , bronzeUpdated))
      case x if x < 0 && currency(1) > 0 =>
        val bronzeUpdated = currency(2) + 10
        val silverUpdated = currency(1) - 1
        currencyCheckerBronze(List(currency(0), silverUpdated , bronzeUpdated))
      case x if x >= 10000 =>
        val bronzeUpdated = currency(2) - 10000
        val silverUpdated = currency(1) + 1000
        currencyCheckerBronze(List(currency(0), silverUpdated, bronzeUpdated))
      case x if x >= 1000 =>
        val bronzeUpdated = currency(2) - 1000
        val silverUpdated = currency(1) + 100
        currencyCheckerBronze(List (currency(0), silverUpdated, bronzeUpdated))
      case x if x >= 100 =>
        val bronzeUpdated = currency(2) - 100
        val silverUpdated = currency(1) + 10
        currencyCheckerBronze(List(currency(0), silverUpdated, bronzeUpdated))
      case x if x >= 10 =>
        val bronzeUpdated = currency(2) - 10
        val silverUpdated = currency(1) + 1
        currencyCheckerBronze(List(currency(0), silverUpdated, bronzeUpdated))
      case x if currency(0) >= 0 && currency(1) >= 0 & x >= 0 =>
        val newCurrency: List[Int] = List(currency(0), currency(1), currency(2))
        println(s"Gold   : ${newCurrency(0)} \nSilver : ${newCurrency(1)} \nBronze : ${newCurrency(2)}")
        println(newCurrency.toString())
        newCurrency
      case _ =>
        println("Not Enought Money")
        currency
    }
  }
}