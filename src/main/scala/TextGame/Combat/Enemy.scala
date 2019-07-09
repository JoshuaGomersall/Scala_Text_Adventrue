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

  class Enemy(var name: String, val typeNumber: Int, var hp: Int = 1000, var attack: Int = 1000, var enemyType: String = "POWERFUL" ,var characterImage :String = "") {
    if (hp == 1000 && enemyType == "POWERFUL") {
      typeNumber.toString match {
        case "1" => println(s"The Enemy Is A Goblin")
          hp = 8
          attack = 4
          enemyType = "Goblin"
          characterImage = "         _..__.          .__.._\n       .^\"-.._ '-(\\__/)-' _..-\"^.   \n              '-.' oo '.-'\n                 `-..-' "
        case "2" => println(s"The Enemy Is A Shadow")
          hp = 5
          attack = 10
          enemyType = "Shadow"
          characterImage = "        .-\"\"\"\"-.\n       / -   -  \\\n      |  .-. .- |\n      |  \\o| |o (\n      \\     ^    \\\n      |'.  )--'  /|\n     / / '-. .-'`\\ \\\n    / /'---` `---'\\ \\\n    '.__.       .__.'\n        `|     |`\n         |     \\\n         \\      '--.\n          '.        `\\\n            `'---.   |\n               ,__) /\n                `..'"
        case "3" => println(s"The Enemy Is A Giant Weasel")
          hp = 20
          attack = 5
          enemyType = "Giant Weasel"
          characterImage = "\n\n                                _,-/\"---,\n         ;\"\"\"\"\"\"\"\"\"\";         _/;; \"\"  <@`---v\n       ; :::::  ::  \"\\      _/ ;;  \"    _.../\n      ;\"     ;;  ;;;  \\___/::    ;;,'\"\"\"\"\n     ;\"          ;;;;.  ;;  ;;;  ::/\n    ,/ / ;;  ;;;______;;;  ;;; ::,/\n    /;;V_;;   ;;;       \\       /\n    | :/ / ,/            \\_ \"\")/\n    | | / /\"\"\"=            \\;;\\\"\"=\n    ; ;{::\"\"\"\"\"\"=            \\\"\"\"=\n ;\"\"\"\";\n \\/\"\"\""
        case "4" => println(s"The Enemy Is A Bat")
          hp = 1
          attack = 2
          enemyType = "Bat"
          characterImage = "         _..__.          .__.._\n       .^\"-.._ '-(\\__/)-' _..-\"^.   \n              '-.' oo '.-'\n                 `-..-' "
        case "5" => println(s"The Enemy Is A Wizard"); hp = 4; attack = 8; enemyType = "Wizard"
      }
    }

    override def toString: String = s"The Enemy is $name and has is $hp"

    def intro: String = s"Hi im $name and im a $enemyType"

    def fullStats: String = s"===========================\n Name: $name \nType: $enemyType \nHealth: $hp \nAttack: $attack\n $characterImage \n==========================="
  }

}
