package TextGame.Character_Creation

import TextGame.GlobalValues

object ClassSelection {
  val playerClass: String = "Monk"

  def classSelection(): String = {
    println("Select A Class Or Type Info And The Class Name For More Information \nType info class for a list of all class options")
    val playerClassCheck = scala.io.StdIn.readLine()
    playerClassCheck.toLowerCase() match {
      case x if x.contains("info") =>
        ClassSelectionInfo.classInfo(x)
        "info"
      case x if x.contains("bard") =>
        classConfirm("bard")
        "bard"
      case x if x.contains("barb") =>
        classConfirm("barbarian")
        "Barbarian"
      case x if x.contains("cleric") =>
        classConfirm("cleric")
        "Cleric"
      case x if x.contains("druid") =>
        classConfirm("druid")
        "Druid"
      case x if x.contains("fighter") =>
        classConfirm("fighter")
        "Fighter"
      case x if x.contains("monk") =>
        classConfirm("monk")
        "Monk"
      case x if x.contains("paladin") =>
        classConfirm("paladin")
        "Paladin"
      case x if x.contains("ranger") =>
        classConfirm("ranger")
        "Ranger"
      case x if x.contains("rogue") =>
        classConfirm("rogue")
        println("You Are Now A Rogue")
        "Rogue"
      case x if x.contains("sorcery") =>
        classConfirm("sorcerer")
        "Sorcery"
      case x if x.contains("warlock") =>
        classConfirm("warlock")
        "Warlock"
      case x if x.contains("wizard") =>
        classConfirm("wizard")
        "Wizard"
      case _ =>
        println("That Class Is Not An Option , You Have Been Set As Fighter By Default")
        "Fighter"
    }
  }


    def classConfirm (playerClass : String) : String = {
      println(s"So Your Class Is : " + playerClass)
      println(s"Is This Class Correct ")
      val input = scala.io.StdIn.readLine()
      if (!GlobalValues.confirmResponse().contains(input)) {
        classSelection()
      }
      playerClass
    }
}