package TextGame

object NameSelect {
  var nameSelected: Boolean = false
  var name: String = "Greg"

  def nameSelect(): String = {
    while (!nameSelected) {
      println(s"Please Enter A Character Name")
      name = scala.io.StdIn.readLine()
      println(s"So Your Name Is : " + name)
      println(s"Is This Name Correct ")
      val input = scala.io.StdIn.readLine()
      if (GlobalValues.confirmResponse().contains(input)) {
        nameSelected = true
        return name
      }
      else {
        nameSelected = false
      }
    }
    "NameSelected"
  }

  def reset(): String = {
    nameSelected = false
    "Done"
  }

}