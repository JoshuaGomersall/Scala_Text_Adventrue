package TextGame.Character_Creation

object ClassSelectionInfo {

  def classInfo(playerClassCheck: String): Unit =
  {
    val playerClassCheckRegex = playerClassCheck.replaceAll("info", "")
    playerClassCheckRegex.toLowerCase() match {
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
}
