package sample.TextGame

object Main {
  def main(args: Array[String]): Unit = {
    val playing: Boolean = true

    GameText("title")

    val confirmInputs: List[String] = List("y", "yes", "yeah" , "yep" ,"yup" ,"sure")


    var name: String = "Greg"
    var playerClass = "Knight"
    //    val hp: Integer = 100
    //    val mana: Integer = 5
    //    val attackDamage: Integer = 2
    //    var inCombat: Boolean = false
    var xDirection: Integer = 0
    var yDirection: Integer = 0

    var xExit: Int = scala.util.Random.nextInt(10) - 5
    var yExit: Int = scala.util.Random.nextInt(10) - 5

    var xEvent: Int = scala.util.Random.nextInt(10) - 5
    var yEvent: Int = scala.util.Random.nextInt(10) - 5


    println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
    CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)


    var nameSelected: Boolean = false
    while (!nameSelected) {
      println(s"Please Enter A Character Name")
      name = scala.io.StdIn.readLine()
      println(s"So Your Name Is : " + name)
      println(s"Is This Name Correct ")
      val input = scala.io.StdIn.readLine()

      if (confirmInputs.contains(input)) {
        nameSelected = true
      }
      else {
        nameSelected = false
      }
    }

    var classSelected: Boolean = false
    var colorSelected: Boolean = false

    while (playing) {
      while (!colorSelected) {
        println(Console.BLACK + "Select A Preferred Text Color")
        val textColor = scala.io.StdIn.readLine()
        textColor.toLowerCase() match {
          case "blue" => println(Console.BLUE + "This is the new text color")
          case "red" => println(Console.RED + "This is the new text color")
          case "green" => println(Console.GREEN + "This is the new text color")
          case "yellow" => println(Console.YELLOW + "This is the new text color")
          case "purple" => println(Console.MAGENTA + "This is the new text color")
          case _ => println("Your Choice Was Invalid , This is the new text color") // the default, catch-all
        }
        println("Are You Happy With This Choice Of Color")
        val input = scala.io.StdIn.readLine()
        if (confirmInputs.contains(input)) {
          colorSelected = true
        }
        else {
          colorSelected = false
        }
      }

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

          if (confirmInputs.contains(input)) {
            classSelected = true
          }
          else {
            classSelected = false
          }
        }
      }
      println("\nTry \"north\", \"south\", \"east\", or \"west\"")

      val input = scala.io.StdIn.readLine()
      println("The user has entered " + input)

      if (input.toLowerCase() == "north") {
        yDirection += 1
      }
      else if (input.toLowerCase() == "south") {
        yDirection -= 1
      }
      else if (input.toLowerCase() == "east") {
        xDirection += 1
      }
      else if (input.toLowerCase() == "west") {
        xDirection -= 1
      }
      println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
      CompassMain(xDirection, xExit, xEvent, yDirection, yExit, yEvent)

      if (xDirection == xEvent && yDirection == yEvent) {
        println("YOU FOUND A THING")
        xEvent = scala.util.Random.nextInt(10) - 5
        yEvent = scala.util.Random.nextInt(10) - 5

        Combat()

      }
      else if (xDirection == xExit && yDirection == yExit) {
        println(s"It Seems You Found The Exit")

        println(s"This Was Not The End But The Start Of The Adventures of " + name + " The " + playerClass)


        println(s"Would You Like To Play Again")
        val inputExit = scala.io.StdIn.readLine()
        if (inputExit.toLowerCase() == "no" || inputExit.toLowerCase() == "n") {
          GameText("gameover")
          sys.exit()
        }
        else {
          println("Starting Over........")
          xDirection = 0
          yDirection = 0
          classSelected = false
          colorSelected = false
          xExit = scala.util.Random.nextInt(10) - 5
          yExit = scala.util.Random.nextInt(10) - 5
          println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
          CompassMain(xDirection, xExit, xEvent, yDirection, xExit, xEvent)
        }
      }
      else if (yDirection == yExit) {
        println(s"The Compass Seems To Sharply Turn The Exit Must Be Left Or Right From Here")
      }
      else if (xDirection == xExit) {
        println(s"The Compass Seems To Sharply Turn The Exit Must Be North Or South From Here")
      }
    }
  }
}