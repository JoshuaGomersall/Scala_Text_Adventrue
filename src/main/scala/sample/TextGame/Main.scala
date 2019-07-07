package sample.TextGame

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val playing: Boolean = true
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

    GameText("title")
    val name :String = NameSelectObject.nameSelect()
    ColorSelectObject.colorSelect()
    val playerClass: String = ClassSelectionObject.classSelection()

    while (playing) {
      println("\nTry \"north\", \"south\", \"east\", or \"west\" Or Use Settings To Change Settings")
      val input = scala.io.StdIn.readLine()
      println("The user has entered " + input)
      input.toLowerCase() match {
        case "north" => yDirection += 1
        case "n" => yDirection += 1
        case "south" => yDirection -= 1
        case "s" => yDirection -= 1
        case "east" => xDirection += 1
        case "e" => xDirection += 1
        case "west" => xDirection -= 1
        case "w" => xDirection -= 1
        case "settings" => ColorSelectObject.reset() ;ColorSelectObject.colorSelect()
        case _ => println("Your Choice Was Invalid , Try And Use North , South , West Or East") // the default, catch-all
      }
      println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
      CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)
      if (xDirection == xEvent && yDirection == yEvent) {
        FindingEventsTextObject.findEventText()
        xEvent = scala.util.Random.nextInt(10) - 5
        yEvent = scala.util.Random.nextInt(10) - 5
        CombatObject.combatStart()
        CombatObject.combatEnd()
      }
      else if (xDirection == xExit && yDirection == yExit) {
        FindingEventsTextObject.findExitText(name,playerClass)
        val inputExit = scala.io.StdIn.readLine()
        if (inputExit.toLowerCase().contains("no") || inputExit.toLowerCase().contains("n")) {
          GameText("gameoverghost")
          sys.exit()
        }
        else {
          FindingEventsTextObject.startingOver()
          xDirection = 0
          yDirection = 0
          xExit = Random.nextInt(10) - 5
          yExit = Random.nextInt(10) - 5
          CompassMain(xDirection, xExit, xEvent, yDirection, xExit, xEvent)
        }
      }
      else if (yDirection == yExit) {
        FindingEventsTextObject.yAlignedWithExitText()
      }
      else if (xDirection == xExit) {
        FindingEventsTextObject.xAlignedWithExitText()
      }
    }
  }
}