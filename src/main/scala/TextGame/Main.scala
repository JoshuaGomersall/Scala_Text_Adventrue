package TextGame

import TextGame.CombatActions._
import TextGame.Text._
import TextGame.Character_Creation._
import TextGame.Settings._
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

    ColorSelect.colorSelect()

    val playerClass: String = ClassSelection.classSelection()

    println(playerClass)
    val player = Player.make(name, playerClass)

    mainGame(xDirection ,yDirection ,xExit ,yExit ,yEvent ,xEvent,player)
  }
  def mainGame(xPlayer: Int , yPlayer: Int, xExit : Int ,yExit: Int ,yEvent :Int, xEvent : Int ,player: Player.Player): Unit = {
    val cordsPlayer = Navigation.movePlayer(xPlayer, yPlayer)
    val xDirection = cordsPlayer(0)
    val yDirection = cordsPlayer(1)

    Compass.compassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

    if (xDirection == xEvent && yDirection == yEvent) {
      FindingEvents.findEventText()
      val xEventNew = 2
      val yEventNew = 2
        Combat.combatStart(player)
    }
    else if (xDirection == xExit && yDirection == yExit) {
      FindingEvents.findExitText(player.name,player.playerClass)
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

    mainGame(xDirection,yDirection,xExit,yExit,yEvent,xEvent,player)
  }
}