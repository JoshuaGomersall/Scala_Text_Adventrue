package TextGame

object NameSelect {
  def nameSelect(): String = {
    val name = scala.io.StdIn.readLine()
    println(s"So Your Name Is : " + name)
    println(s"Is This Name Correct ")
    val input = scala.io.StdIn.readLine()
    if (GlobalValues.confirmResponse().contains(input) == false) {
      nameSelect()
    }
    name
  }
}