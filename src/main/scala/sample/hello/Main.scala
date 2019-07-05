package sample.hello

object Main {
  def main(args: Array[String]): Unit = {
    var playing: Boolean = true

    val hp: Integer = 100
    val mana: Integer = 5
    val attackDamage: Integer = 2
    var inCombat: Boolean = false

    var xDirection: Integer = 0
    var yDirection: Integer = 0

    var xExit: Integer = scala.util.Random.nextInt(10) -5
    var yExit: Integer = scala.util.Random.nextInt(10) -5

    println(s"You Are Now At " + yDirection + " North and " + xDirection+" East")
    println(s"The Exit Is At " + yExit + " North and " + xExit + " East")

    var nameSelected: Boolean = false
    while (nameSelected == false){
      println(s"Please Enter A Character Name")
      val name=scala.io.StdIn.readLine()
      println(s"So Your Name Is : "+ name)
      println(s"Is This Name Correct ")
      val input=scala.io.StdIn.readLine()

      if (input == "yes" || input == "y"){
        nameSelected = true
        nameSelected = true
      }
      else {
        nameSelected = false
      }
    }

    var classSelected: Boolean = false
    var colorSelected: Boolean = false

    while (playing)
    {
      while (colorSelected == false) {
        println("Select A Prefered Color")
        val textColor = scala.io.StdIn.readLine()

        if (textColor.toLowerCase() == "blue") {println(Console.BLUE + "This is the new text color")}
        else if (textColor.toLowerCase() == "red") {println(Console.RED + "This is the new text color")}
        else if (textColor.toLowerCase() == "white") {println(Console.WHITE + "This is the new text color")}
        else if (textColor.toLowerCase() == "black") {println(Console.BLACK + "This is the new text color")}
        else if (textColor.toLowerCase() == "green") {println(Console.GREEN + "This is the new text color")}
        else if (textColor.toLowerCase() == "yellow") {println(Console.YELLOW + "This is the new text color")}
        else if (textColor.toLowerCase() == "purple") {println(Console.MAGENTA + "This is the new text color")}

        println("Are You Happy With This Choice Of Color")
        val input = scala.io.StdIn.readLine()
        if (input == "yes" || input == "y") {
          colorSelected = true
        }
        else {
          colorSelected = false
        }
      }

      while (classSelected == false){
        println("Select A Class Or Type Info Followed By The Class Name For More Information")
        val playerClassCheck=scala.io.StdIn.readLine()
        var playerClass = "Knight"

        if (playerClassCheck.toLowerCase() == "knight"){
          println("You Are Now A Knight")
          playerClass = "Knight"
        }
        else if (playerClassCheck.toLowerCase() == "theif"){
          println("You Are Now A Theif")
          playerClass = "Theif"
        }
        else {
          println("That Class Is Not An Option , You Have Been Set As Knight By Default")
          playerClass = "Knight"
        }

        println(s"So Your Class Is : " + playerClass)
        println(s"Is This Class Correct ")
        val input = scala.io.StdIn.readLine()

        if (input == "yes" || input == "y") {
          classSelected = true
        }
        else {
          classSelected = false
        }
      }
      println("\nTry \"north\", \"south\", \"east\", or \"west\"")

      val input=scala.io.StdIn.readLine()
      println("The user has entered "+ input)

      if (input.toLowerCase() == "north"){
        yDirection += 1
      }
      else if (input.toLowerCase() == "south"){
        yDirection -= 1
      }
      else if (input.toLowerCase() == "east"){
        xDirection += 1
      }
      else if (input.toLowerCase() == "west"){
        xDirection -= 1
      }
      println(s"You Are Now At " + yDirection + " North and " + xDirection+" East")
      println(s"The Exit Is At " + yExit + " North and " + xExit + " East")

      if (xDirection == xExit && yDirection == yExit){
        println(s"It Seems You Found The Exit")
        println(s"Would You Like To Play Again")
        val inputExit=scala.io.StdIn.readLine()
        if (inputExit.toLowerCase() == "no" || inputExit.toLowerCase() == "n") {
          println("Game Over........")
          return 0
        }
        else {
          println("Starting Over........")
          xDirection = 0
          yDirection = 0

          classSelected = false
          colorSelected = false

          xExit = scala.util.Random.nextInt(10) -5
          yExit = scala.util.Random.nextInt(10) -5
          println(s"You Are Now At " + yDirection + " North and " + xDirection+" East")
          println(s"The Exit Is At " + yExit + " North and " + xExit + " East")
        }
      }
      else if (yDirection == yExit){
        println(s"The Exit Must Be Left Or Right From Here")
      }
      else if (xDirection == xExit){
        println(s"The Exit Must Be North Or South From Here")
      }
    }
  }
}