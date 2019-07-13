package TextGame

import TextGame.Character_Creation.NameSelect
import TextGame.CombatActions._
import TextGame.Text.FindingEvents
import TextGame.Character_Creation._
import TextGame.MovementAndNavigation._

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    Inventory.equiptItem("sword")
    Inventory.equiptItem("armor")
    println(Inventory.addItemToBackPack("armor"))
    Inventory.equiptItem("armor ")

    val xDirection: Int = 0
    val yDirection: Int = 0
    val xExit: Int = Random.nextInt(10) - 5
    val yExit: Int = Random.nextInt(10) - 5
    val xEvent: Int = scala.util.Random.nextInt(10) - 5
    val yEvent: Int = scala.util.Random.nextInt(10) - 5

    TitleText("title")
    println("Select A Character Name")
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
    val player = Player.makePlayer(name, playerClass)

    var cordsPlayer: List[Int] = List(xDirection, yDirection)
  }

  def mainGame(xPlayer: Int , yPlayer: Int, xExit : Int ,yExit: Int ,yEvent :Int, xEvent : Int ,name: String, playerClass: String, player: Player.Player): Unit = {
    val cordsPlayer = Navigation.movePlayer(xPlayer, yPlayer)
    val xDirection = cordsPlayer(0)
    val yDirection = cordsPlayer(1)
    println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")

    CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

    if (xDirection == xEvent && yDirection == yEvent) {
      FindingEvents.findEventText()
      val xEventNew = scala.util.Random.nextInt(10) - 5
      val yEventNew = scala.util.Random.nextInt(10) - 5
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
        val xExit = Random.nextInt(10) - 5
        val yExit = Random.nextInt(10) - 5
        CompassMain(xDirection, xExit, xEvent, yDirection, xExit, xEvent)
      }
    }
    else if (yDirection == yExit) {
      FindingEvents.yAlignedWithExitText()
    }
    else if (xDirection == xExit) {
      FindingEvents.xAlignedWithExitText()
    }
  }
}