package TextGame

import TextGame.CombatActions._
import TextGame.Text.FindingEvents

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {

    Inventory.equiptItem("sword")

    Inventory.equiptItem("armor")

    println(Inventory.addItemToBackPack("armor"))

    Inventory.equiptItem("armor ")

    val playing: Boolean = true
    //    val hp: Integer = 100
    //    val mana: Integer = 5
    //    val attackDamage: Integer = 2
    //    var inCombat: Boolean = false
    var xDirection: Int = 0
    var yDirection: Int = 0
    var xExit: Int = Random.nextInt(10) - 5
    var yExit: Int = Random.nextInt(10) - 5
    var xEvent: Int = scala.util.Random.nextInt(10) - 5
    var yEvent: Int = scala.util.Random.nextInt(10) - 5

    TitleText("title")
    val name: String = NameSelect.nameSelect()
    ColorSelect.colorSelect()
    val playerClass: String = ClassSelection.classSelection()

    println(playerClass)
    val player = Player.makePlayer(name ,playerClass)

    var cordsPlayer: List[Int] = List(xDirection, yDirection)

    while (playing) {
      //
      cordsPlayer = Navigation.movePlayer(xDirection, yDirection)
      xDirection = cordsPlayer(0)
      yDirection = cordsPlayer(1)
      println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")

      CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

      if (xDirection == xEvent && yDirection == yEvent) {
        FindingEvents.findEventText()
        xEvent = scala.util.Random.nextInt(10) - 5
        yEvent = scala.util.Random.nextInt(10) - 5
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
          xDirection = 0
          yDirection = 0
          xExit = Random.nextInt(10) - 5
          yExit = Random.nextInt(10) - 5
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
}