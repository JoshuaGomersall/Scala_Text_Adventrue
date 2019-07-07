package sample.TextGame

object FindingEventsTextObject {

  def findEventText(): String = {
    println("YOU FOUND A THING")
    return "Done"
  }

  def findExitText(name: String , playerClass: String): String = {
    println("YOU FOUND A THING")
    println(s"It Seems You Found The Exit")
    println(s"This Was Not The End But The Start Of The Adventures of $name + The $playerClass")
    println(s"Would You Like To Play Again")
    return "Done"
  }
  def startingOver(): String = {
    println("Starting Over........")
    NameSelectObject.reset()
    NameSelectObject.nameSelect()
    ColorSelectObject.reset()
    ColorSelectObject.colorSelect()
    ClassSelectionObject.reset()
    ClassSelectionObject.classSelection()
    println(s"You Are Now At 0 North and 0 East")
    return "Done"
  }

  def yAlignedWithExitText(): String = {
    println(s"The Compass Seems To Sharply Turn The Exit Must Be Left Or Right From Here")
    return "Done"
  }

  def xAlignedWithExitText(): String = {
    println(s"The Compass Seems To Sharply Turn The Exit Must Be North Or South From Here")
    return "Done"
  }
}