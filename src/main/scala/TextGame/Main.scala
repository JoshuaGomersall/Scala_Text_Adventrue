package TextGame

import TextGame.CombatActions._
import TextGame.Text.{FindingEvents, TitleText}
import TextGame.Character_Creation._
import TextGame.MovementAndNavigation._

object Main {
  def main(args: Array[String]): Unit = {
    val xDirection: Int = 0
    val yDirection: Int = 0
    val xExit: Int = 2 //Random.nextInt(10) - 5
    val yExit: Int = 2 //Random.nextInt(10) - 5
    val xEvent: Int = 3 //scala.util.Random.nextInt(10) - 5
    val yEvent: Int = 3 //scala.util.Random.nextInt(10) - 5

    TitleText("title")

    val name: String = NameSelect.nameSelect()


    println(Console.BLACK + "Select A Preferred Text Color")
    println(Console.BLUE + "This is blue")
    println(Console.RED + "This is red")
    println(Console.GREEN + "This is green")
    println(Console.YELLOW + "This is yellow")
    println(Console.MAGENTA + "This is purple")
    ColorSelect.colorSelect(scala.io.StdIn.readLine())


    val playerClass: String = ClassSelection.classSelection()

    println(playerClass)
    val player = Player.make(name, playerClass)

    mainGame(xDirection ,yDirection ,xExit ,yExit ,yEvent ,xEvent ,name,playerClass,player)
  }
  def mainGame(xPlayer: Int , yPlayer: Int, xExit : Int ,yExit: Int ,yEvent :Int, xEvent : Int ,name: String, playerClass: String, player: Player.Player): Unit = {
    val cordsPlayer = Navigation.movePlayer(xPlayer, yPlayer)
    val xDirection = cordsPlayer(0)
    val yDirection = cordsPlayer(1)
    println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")

    Compass.compassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

    if (xDirection == xEvent && yDirection == yEvent) {
      FindingEvents.findEventText()
      val xEventNew = 2
      val yEventNew = 2
        Combat.combatStart(player)
    }
    else if (xDirection == xExit && yDirection == yExit) {
      FindingEvents.findExitText(name, playerClass)
      val inputExit = scala.io.StdIn.readLine()
      if (inputExit.toLowerCase().contains("no") || inputExit.toLowerCase().contains("n")) {
        TitleText("gameoverghost")
        sys.exit()
      }
      else {
        FindingEvents.startingOver()
        val xDirection = 0
        val yDirection = 0
        val xExit = 3
        val yExit = 3
        Compass.compassMain(xDirection,xExit,xEvent,yDirection,yExit,yEvent)
      }
    }
    else if (yDirection == yExit) {
      FindingEvents.yAlignedWithExitText()
    }
    else if (xDirection == xExit) {
      FindingEvents.xAlignedWithExitText()
    }

    mainGame(xDirection,yDirection,xExit,yExit,yEvent,xEvent,name,playerClass,player)
  }
}