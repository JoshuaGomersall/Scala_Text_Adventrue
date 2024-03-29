package TextGame.MovementAndNavigation

object Navigation {
  def movePlayer(xPlayer: Int, yPlayer: Int): List[Int] = {

    println("\nTry \"north\", \"south\", \"east\", or \"west\" Or Use Settings To Change Settings")
    val input = scala.io.StdIn.readLine()
    println("The user has entered " + input)
    input.toLowerCase() match {
      case "north" | "n" =>
        val yDirectionUpdated = yPlayer + 1
        displayLocation(yDirectionUpdated.toString,xPlayer.toString)
        List(xPlayer ,yDirectionUpdated)
      case "south" | "s" =>
        val yDirectionUpdated = yPlayer - 1
        displayLocation(yDirectionUpdated.toString ,xPlayer.toString)
        List(xPlayer, yDirectionUpdated)
      case "east"  | "e" =>
        val xDirectionUpdated = xPlayer + 1
        displayLocation(yPlayer.toString,xDirectionUpdated.toString)
        List(xDirectionUpdated ,yPlayer)
      case "west"  | "w" =>
        val xDirectionUpdated = xPlayer - 1
        displayLocation(yPlayer.toString , xDirectionUpdated.toString)
          List(xDirectionUpdated , yPlayer)
      case _ => println("Your Choice Was Invalid , Try And Use North , South , West Or East")
        List(yPlayer,xPlayer)
    }
  }

  def displayLocation (xPlayer: String ,yPlayer: String): Unit = {
    println(s"You Are Now At " + xPlayer + " North and " + yPlayer + " East")
  }
}