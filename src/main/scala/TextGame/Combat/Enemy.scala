package TextGame

object Enemy {
  def makeEnemy(): Enemy = {
    val enemyType: Int = scala.util.Random.nextInt(4) + 1
    val enemy = new Enemy("Greg", enemyType)
    enemy
  }

  def enemyTakeDamage(enemy: Enemy , damage: Int): Enemy = {
    enemy.hp -= damage
    enemy
  }

  def enemyHeal(enemy: Enemy , healAmount: Int): Enemy = {
    enemy.hp += healAmount
    enemy
  }

  def enemyIntro(name: String, enemyType: String): String = {
    println(s"Hi im $name and im a $enemyType")
    s"Hi im $name and im a $enemyType"
  }

  def enemyFullStats(enemy: Enemy): String = {
    enemy.fullStats.toString
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

    def fullStats: String = s"Name: $name \nType: $enemyType \nHealth: $hp \nAttack: $attack"
  }

}
