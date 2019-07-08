package TextGame

object ClassSelection {
  var classSelected: Boolean = false
  var playerClass: String = "Monk"

  def classSelection(): String = {
    while (!classSelected) {
      println("Select A Class Or Type Info And The Class Name For More Information \nType info class for a list of all class options")
      var playerClassCheck = scala.io.StdIn.readLine()
      if (playerClassCheck.toLowerCase().contains("info")) {
        playerClassCheck = playerClassCheck.replaceAll("info", "")

        playerClassCheck.toLowerCase() match {
          case " class" => println("Bard ,Barbarian ,Cleric ,Druid ,Fighter ,Monk ,Paladin ,Ranger ,Rogue ,Sorcery ,Warlock ,Wizard ")
          case _ if playerClassCheck.contains("bard") => println("Bard - a story teller or musician using his wits, magic, and lore to get out of (or avoid) tight situations")
          case _ if playerClassCheck.contains("barb") => println("Barbarian - the relentless combatant, fueled by fury or it's totem bonds with animals. In tune with the natural order.")
          case _ if playerClassCheck.contains("cleric") => println("Cleric - a Holy man devoted to a deity. capable of bolstering the party and heal their wounds, or laying low their enemies with divine wrath.")
          case _ if playerClassCheck.contains("druid") => println("Druid - a nomad devoted to the world and the powers of Nature. Capable of adopting the form of a beast for battle or utility. capable of bolstering the party and heal their wounds, or laying low their enemies with nature's wrath")
          case _ if playerClassCheck.contains("fighter") => println("Fighter - Skilled combatant or strategist typically relying on his heavy armor and weapons to cut down their enemies. His training gives him unique abilities")
          case _ if playerClassCheck.contains("monk") => println("Monk - martial artist pulling on the power of his own body to produce impressive results.")
          case _ if playerClassCheck.contains("paladin") => println("Paladin - nearly as skilled as the Fighter but bolsters his efforts with divine magic. through his devotion he gains special boons from his god.")
          case _ if playerClassCheck.contains("ranger") => println("Ranger - one who uses a unique blend of wilderness knowledge and martial ability to be a deadly hunter, with a bow, a pet or melee weapons")
          case _ if playerClassCheck.contains("rogue") => println("Rogue - a thief, assassin or stealthy character who has a knack for picking out his enemies weaknesses and exploiting them.")
          case _ if playerClassCheck.contains("sorcery") => println("Sorcery - a magic user who draws his power from within, summoning his innate magical power and bending it to his will")
          case _ if playerClassCheck.contains("warlock") => println("Warlock - pacted to a powerful entity the warlock trades favors for boons and spells")
          case _ if playerClassCheck.contains("wizard") => println("Wizard - keeper of arcane secrets and forgotten knowledge, the wizard manipulates magic and spells with cunning.")
          case " " => println("Please Add The Class Name After The Words Info")
          case _ => println("That Class Is Not An Option")
        }
      }
      else {
        playerClassCheck.toLowerCase() match {
          case _ if playerClassCheck.contains("bard") => println("You Are Now A Bard"); playerClass = "Bard"
          case _ if playerClassCheck.contains("barb") => println("You Are Now A Barbarian"); playerClass = "Barbarian"
          case _ if playerClassCheck.contains("cleric") => println("You Are Now A Cleric"); playerClass = "Cleric"
          case _ if playerClassCheck.contains("druid") => println("You Are Now A Druid"); playerClass = "Druid"
          case _ if playerClassCheck.contains("fighter") => println("You Are Now A Fighter"); playerClass = "Fighter"
          case _ if playerClassCheck.contains("monk") => println("You Are Now A Monk"); playerClass = "Monk"
          case _ if playerClassCheck.contains("paladin") => println("You Are Now A Paladin"); playerClass = "Paladin"
          case _ if playerClassCheck.contains("ranger") => println("You Are Now A Ranger"); playerClass = "Ranger"
          case _ if playerClassCheck.contains("rogue") => println("You Are Now A Rogue"); playerClass = "Rogue"
          case _ if playerClassCheck.contains("sorcery") => println("You Are Now A Sorcery"); playerClass = "Sorcery"
          case _ if playerClassCheck.contains("warlock") => println("You Are Now A Warlock"); playerClass = "Warlock"
          case _ if playerClassCheck.contains("wizard") => println("You Are Now A Wizard"); playerClass = "Wizard"
          case _ => println("That Class Is Not An Option , You Have Been Set As Knight By Default"); playerClass = "Knight"
        }
        println(s"So Your Class Is : " + playerClass)
        println(s"Is This Class Correct ")
        val input = scala.io.StdIn.readLine()

        if (GlobalValues.confirmResponse().contains(input)) {
          classSelected = true
          return playerClass
        }
        else {
          classSelected = false
        }
      }
    }
    playerClass
  }

  def reset(): String = {
    classSelected = false
    "Done"
  }
}