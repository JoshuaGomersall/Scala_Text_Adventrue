package TextGame

import TextGame.CombatActions._
import TextGame.Text._
import TextGame.Character_Creation._
import TextGame.Settings._
import TextGame.MovementAndNavigation._
import TextGame.PlayerAdvancements.Player
import TextGame.RandomAndEventCreation._

object Main {
  def main(args: Array[String]): Unit = {
    val xDirection: Int = 0
    val yDirection: Int = 0
    val xExit: Int = Random.integerValue(100)
    val yExit: Int = Random.integerValue(100)
    Thread.sleep(100)
    val xEvent: Int = Random.integerValue(100)
    val yEvent: Int = Random.integerValue(100)

    TitleText("title")

    val player = characterCreation()

    mainGame(xDirection ,yDirection ,xExit ,yExit ,yEvent ,xEvent,player)
  }

  def characterCreation () : Player.Player ={
    val name: String = NameSelect.nameSelect()
    ColorSelect.colorSelect()
    val playerClass: String = ClassSelection.classSelection()
    println(playerClass)
    Player.make(name, playerClass)
  }

  def mainGame(xPlayer: Int , yPlayer: Int, xExit : Int ,yExit: Int ,yEvent :Int, xEvent : Int ,player: Player.Player): Unit = {
    val cordsPlayer = Navigation.movePlayer(xPlayer, yPlayer)
    val xDirection = cordsPlayer(0)
    val yDirection = cordsPlayer(1)

    Compass.compassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)


    xDirection match {
      case x if x == xExit && yDirection ==yExit =>
        FindingEvents.findExitText(player.name,player.playerClass)
        val inputExit = scala.io.StdIn.readLine()
        if (inputExit.toLowerCase().contains("no") || inputExit.toLowerCase().contains("n")) {
          TitleText("gameoverghost")
          sys.exit()}
          else {
            val newPLayer = characterCreation()
            val xDirection = 0
            val yDirection = 0
          Thread.sleep(100)
            val xExit = Random.integerValue(100)
            val yExit = Random.integerValue(100)
          Thread.sleep(100)
            mainGame(xDirection ,yDirection ,xExit ,yExit ,Random.integerValue(100),Random.integerValue(100),player)
            Compass.compassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)
          }
      case x if yDirection == yExit => FindingEvents.yAlignedWithExitText()

      case x if x ==xExit => FindingEvents.xAlignedWithExitText()

      case x if x == xEvent && yDirection == yEvent
      => FindingEvents.findEventText()
        val xEventNew = Random.integerValue(100)
        val yEventNew = Random.integerValue(100)
        Combat.combatStart(player)

      case _ => println("You Are Still Searching")
    }
    mainGame(xDirection,yDirection,xExit,yExit,yEvent,xEvent,player)
  }
}