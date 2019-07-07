package sample.TextGame

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val playing: Boolean = true

    GameText("title")

    var name: String = "Greg"
    //    val hp: Integer = 100
    //    val mana: Integer = 5
    //    val attackDamage: Integer = 2
    //    var inCombat: Boolean = false

    var xDirection: Integer = 0
    var yDirection: Integer = 0

    var xExit: Int = Random.nextInt(10) - 5
    var yExit: Int = Random.nextInt(10) - 5

    var xEvent: Int = scala.util.Random.nextInt(10) - 5
    var yEvent: Int = scala.util.Random.nextInt(10) - 5

    println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
    CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

    var nameSelected: Boolean = false
    while (!nameSelected) {
      println(s"Please Enter A Character Name")
      name = scala.io.StdIn.readLine()
      println(s"So Your Name Is : " + name)
      println(s"Is This Name Correct ")
      val input = scala.io.StdIn.readLine()

      if (GlobalValuesObject.confirmResponse().contains(input)) {
        nameSelected = true
      }
      else {
        nameSelected = false
      }
    }

    while (playing) {
      ColorSelectObject.colorSelect()

      val playerClass: String = ClassSelectionObject.classSelection()

      println("\nTry \"north\", \"south\", \"east\", or \"west\" Or Use Settings To Change Settings")

      val input = scala.io.StdIn.readLine()
      println("The user has entered " + input)

      if (input.toLowerCase() == "north" || input.toLowerCase() == "n") {
        yDirection += 1
      }
      else if (input.toLowerCase() == "south" || input.toLowerCase() == "s") {
        yDirection -= 1
      }
      else if (input.toLowerCase() == "east" || input.toLowerCase() == "e") {
        xDirection += 1
      }
      else if (input.toLowerCase() == "west" || input.toLowerCase() == "w") {
        xDirection -= 1
      }
      else if (input.toLowerCase() == "settings") {
        ColorSelectObject.reset()
        ColorSelectObject.colorSelect()
      }

      println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
      CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

      if (xDirection == xEvent && yDirection == yEvent) {
        println("YOU FOUND A THING")
        xEvent = scala.util.Random.nextInt(10) - 5
        yEvent = scala.util.Random.nextInt(10) - 5

        CombatObject.CombatStart()

      }
      else if (xDirection == xExit && yDirection == yExit) {
        println(s"It Seems You Found The Exit")

        println(s"This Was Not The End But The Start Of The Adventures of " + name + " The " + playerClass)


        println(s"Would You Like To Play Again")
        val inputExit = scala.io.StdIn.readLine()
        if (inputExit.toLowerCase().contains("no") || inputExit.toLowerCase().contains("n")) {
          GameText("gameoverghost")
          sys.exit()
        }
        else {
          println("Starting Over........")
          xDirection = 0
          yDirection = 0
          ColorSelectObject.reset()
          ColorSelectObject.colorSelect()
          ClassSelectionObject.reset()
          ClassSelectionObject.classSelection()
          xExit = scala.util.Random.nextInt(10) - 5
          yExit = scala.util.Random.nextInt(10) - 5
          println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
          CompassMain(xDirection, xExit, xEvent, yDirection, xExit, xEvent)
        }
      }
      else if (yDirection == yExit) {
        println(s"The Compass Seems To Sharply Turn The Exit Must Be Left Or Right From Here")
      }
      else if (xDirection == xExit) {
        println(s"The Compass Seems To Sharply Turn The Exit Must Be North Or South From Here")
      }
    }
  }
}