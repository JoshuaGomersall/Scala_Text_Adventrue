package TextGame

object ColorSelect {
  def colorSelect(colorChoice: String): Unit = {
    colorChoice.toLowerCase() match {
      case "blue" => println(Console.BLUE + "This is the new text color")
      case "red" => println(Console.RED + "This is the new text color")
      case "green" => println(Console.GREEN + "This is the new text color")
      case "yellow" => println(Console.YELLOW + "This is the new text color")
      case "purple" => println(Console.MAGENTA + "This is the new text color")
      case _ => println(Console.BLACK + "Your Choice Was Invalid , This is the new text color") // the default, catch-all
    }
    println("Are You Happy With This Choice Of Color")
    val input = scala.io.StdIn.readLine()
    if (!GlobalValues.confirmResponse().contains(input)) {
      colorSelect(scala.io.StdIn.readLine())
    }
  }
}