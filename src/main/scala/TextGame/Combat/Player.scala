package TextGame.Combat

object Player {

  def makePlayer(name: String, playerClass: String): Player = {
    val player = new Player(name, playerClass)
    player
  }

  def playerTakeDamage(player: Player , damage: Int): Player = {
    player.hp -= damage
    player
  }

  def playerHeal(player: Player , healAmount: Int): Player = {
    player.hp += healAmount
    player
  }

  def playerFullStats(player: Player): String = {
    player.fullStats.toString
  }

  class Player(var name: String, var playerClass: String, var hp: Int = 100, var attack: Int = 10) {
    playerClass.toLowerCase match {
      case "bard" => println(s"The Enemy Is A Goblin")
      case _ => println(s"The Class Is Invalid ,Default Stats Set")
    }

    override def toString: String = s"The Enemy is $name and has is $hp"

    def intro: String = s"Hi im $name and im a $playerClass"

    def fullStats: String = s"===========================\n Name: $name \nClass: $playerClass \nHealth: $hp \nAttack: $attack \n==========================="
  }

}
