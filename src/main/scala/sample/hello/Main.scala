package sample.hello

object Main {
  def main(args: Array[String]): Unit = {
    var playing: Boolean = true

//    val hp: Integer = 100
//    val mana: Integer = 5
//    val attackDamage: Integer = 2
//    var inCombat: Boolean = false

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


    while (playing)
    {
      val input=scala.io.StdIn.readLine()
      println("The user has entered "+ input)

      if (input == "north"){
        yDirection += 1
      }
      else if (input == "south"){
        yDirection -= 1
      }
      else if (input == "east"){
        xDirection += 1
      }
      else if (input == "west"){
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