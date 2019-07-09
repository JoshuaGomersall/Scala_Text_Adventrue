package TextGame.CombatActions

import TextGame.Enemy

object Combat {
  def combatStart(player: Player.Player): Player.Player = {
    val newEnemy = Enemy.makeEnemy()
    println("Combat Has Started")
    Enemy.enemyIntro(newEnemy.name, newEnemy.enemyType)
    while (newEnemy.hp > 0) {
      println(s"Select An Action You Can Attack , Heal Or Use Enemy Stats or Player Stats For More Information")
      val userAction = scala.io.StdIn.readLine()
      userAction.toLowerCase() match {
        case "enemy stats" => println(newEnemy.fullStats)
        case "player stats" => println(player.fullStats)
        case "attack" => Enemy.enemyTakeDamage(newEnemy, player.attack)
        case "heal" => Player.playerHeal(player, 5)
        case _ => println("That Was An Invalid Action")
      }

      if (newEnemy.hp < 1) {
        println("You Win")
        println(newEnemy.fullStats)
        combatEnd()
      }
    }
    player
  }




  def combatEnd(): String = {
    println("Combat Has Ended")
    "End"
  }
}
