package TextGame

object Navigation {
  def movePlayer(xPlayer: Int, yPlayer: Int): List[Int] = {
    var xDirection = xPlayer
    var yDirection = yPlayer
    println("\nTry \"north\", \"south\", \"east\", or \"west\" Or Use Settings To Change Settings")
    val input = scala.io.StdIn.readLine()
    println("The user has entered " + input)
    input.toLowerCase() match {
      case "north" => yDirection += 1
      case "n" => yDirection += 1
      case "south" => yDirection -= 1
      case "s" => yDirection -= 1
      case "east" => xDirection += 1
      case "e" => xDirection += 1
      case "west" => xDirection -= 1
      case "w" => xDirection -= 1
      case "settings" => ColorSelect.reset(); ColorSelect.colorSelect()
      case _ => println("Your Choice Was Invalid , Try And Use North , South , West Or East") // the default, catch-all
    }
    println(s"You Are Now At " + yDirection + " North and " + xDirection + " East")
    List(xDirection, yDirection)
  }
}