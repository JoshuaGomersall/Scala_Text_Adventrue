package sample.TextGame


object CombatObject {
  def combatStart(): String = {
    var enemyType: Int = scala.util.Random.nextInt(4) + 1
    val enemy = new Enemy("Greg", enemyType)
    println("Combat Has Started")
    println(enemy.intro)
    return "Start"
  }

  def combatEnd(): String = {
    println("Combat Has Ended")
    return "End"
  }
}


class Enemy(var name: String, val typeNumber: Int, var hp: Int = 1000, var attack: Int = 1000, var enemyType: String = "POWERFUL") {

  if (hp == 1000 && enemyType == "POWERFUL") {
    typeNumber.toString match {
      case "1" => println(s"The Enemy Is A Goblin"); hp = 8; attack = 4; enemyType = "Goblin"
      case "2" => println(s"The Enemy Is A Shadow"); hp = 5; attack = 10; enemyType = "Shadow"
      case "3" => println(s"The Enemy Is A Giant Weasel"); hp = 20; attack = 5; enemyType = "Giant Weasel"
      case "4" => println(s"The Enemy Is A Bat"); hp = 1; attack = 2; enemyType = "Bat"
      case "5" => println(s"The Enemy Is A Wizard"); hp = 4; attack = 8; enemyType = "Wizard"
    }
  }

  override def toString: String = s"The Enemy is $name and has is $hp"

  def intro: String = s"Hi im $name and im a $enemyType"
}
