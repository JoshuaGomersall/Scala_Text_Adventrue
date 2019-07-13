package TextGame

import TextGame.Character_Creation.ClassSelectionInfo

object ClassSelection {
  val playerClass: String = "Monk"

  def classSelection(): String = {
    println("Select A Class Or Type Info And The Class Name For More Information \nType info class for a list of all class options")
    val playerClassCheck = scala.io.StdIn.readLine()
    if (playerClassCheck.toLowerCase().contains("info")) {
      ClassSelectionInfo.classInfo(playerClass)
      classSelection()
      "info"
    }
    else {
      playerClassCheck.toLowerCase() match {
        case x if x.contains("bard") =>
          println("You Are Now A Bard")
          return "Bard"
        case x if x.contains("barb") =>
          println("You Are Now A Barbarian")
          return "Barbarian"
        case x if x.contains("cleric") =>
          println("You Are Now A Cleric")
          return "Cleric"
        case x if x.contains("druid") =>
          println("You Are Now A Druid")
          "Druid"
        case x if x.contains("fighter") =>
          println("You Are Now A Fighter")
          "Fighter"
        case x if x.contains("monk") =>
          println("You Are Now A Monk")
          "Monk"
        case x if x.contains("paladin") =>
          println("You Are Now A Paladin")
          "Paladin"
        case x if x.contains("ranger") =>
          println("You Are Now A Ranger")
          "Ranger"
        case x if x.contains("rogue") =>
          println("You Are Now A Rogue")
          "Rogue"
        case x if x.contains("sorcery") =>
          println("You Are Now A Sorcery")
          "Sorcery"
        case x if x.contains("warlock") =>
          println("You Are Now A Warlock")
          "Warlock"
        case x if x.contains("wizard") =>
          println("You Are Now A Wizard")
          "Wizard"
        case x =>
          println("That Class Is Not An Option , You Have Been Set As Fighter By Default")
          "Fighter"
      }
      println(s"So Your Class Is : " + playerClass)
      println(s"Is This Class Correct ")
      val input = scala.io.StdIn.readLine()

      if (GlobalValues.confirmResponse().contains(input) == false) {
        classSelection()
      }
    }
  }
}