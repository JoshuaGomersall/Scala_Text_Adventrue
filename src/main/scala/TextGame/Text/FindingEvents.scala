package TextGame.Text

import TextGame.Character_Creation._
import TextGame.Settings.ColorSelect
import TextGame.Character_Creation.NameSelect._

object FindingEvents {

  def findEventText(): String = {
    println("YOU FOUND A THING")
    "Done"
  }

  def findExitText(name: String, playerClass: String): String = {
    println("YOU FOUND A THING")
    println(s"It Seems You Found The Exit")
    println(s"This Was Not The End But The Start Of The Adventures of $name The $playerClass")
    println(s"Would You Like To Play Again")
    "Done"
  }

  def startingOver(): String = {
    println("Starting Over........")
    println(s"You Are Now At 0 North and 0 East")
    "Done"
  }

  def yAlignedWithExitText(): String = {
    println(s"The Compass Seems To Sharply Turn The Exit Must Be Left Or Right From Here")
    "Done"
  }

  def xAlignedWithExitText(): String = {
    println(s"The Compass Seems To Sharply Turn The Exit Must Be North Or South From Here")
    "Done"
  }
}
