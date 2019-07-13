package TextGame.Character_Creation

import TextGame.GlobalValues

object NameSelect {
  def nameSelect(name: String = "PlaceHolder"): String = {
    name.toLowerCase() match {
      case "PlaceHolder" =>
        name
      case _ =>
        println("Select A Character Name")
        val name = scala.io.StdIn.readLine()
        println(s"So Your Name Is : " + name)
        println(s"Is This Name Correct ")
        val input = scala.io.StdIn.readLine()
        if (!GlobalValues.confirmResponse().contains(input)) {
          nameSelect(scala.io.StdIn.readLine())
        }
        name
    }
  }
}
