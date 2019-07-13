package TextGame

object Navigation {
  def movePlayer(xPlayer: Int, yPlayer: Int): List[Int] = {
    val xDirection = xPlayer
    val yDirection = yPlayer
    println("\nTry \"north\", \"south\", \"east\", or \"west\" Or Use Settings To Change Settings")
    val input = scala.io.StdIn.readLine()
    println("The user has entered " + input)
    input.toLowerCase() match {
      case "north" | "n" => val yDirectionUpdated = yDirection - 1
      case "south" | "s" => val yDirectionUpdated = yDirection - 1
      case "east"  | "e" => val xDirectionUpdated = xDirection + 1
      case "west"  | "w" => val xDirectionUpdated = xDirection - 1
      case _ => println("Your Choice Was Invalid , Try And Use North , South , West Or East") // the default, catch-all
    }
    println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
    List(xDirection, yDirection)
  }
}