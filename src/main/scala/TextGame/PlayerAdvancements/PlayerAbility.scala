package TextGame.PlayerAdvancements

object PlayerAbility {
  def main(args: Array[String]): Unit = {
    val newSkillGained = new Furry
    val newSkillGained2 = new WildShape

    val allAbilitys : Set[Ability] = Set[Ability](newSkillGained,newSkillGained2)

    println(allAbilitys.toString())

  }

  def createSkillList () :Unit = {
    lazy val allSkills: Set[String] = Set("Fury", "WildShape")
    lazy val playerSkills: Set[String] = Set("")
  }

  def addNewSkill (newSkill: String , playerSkills: String) : Unit = {
    val updatedPlayerSkills = playerSkills + newSkill
    println(updatedPlayerSkills)
  }

  abstract class Ability(skillName :String = "ExampleName",skillDesc :String  = "Example Desc",skillRank :Int = 1) {
    override def toString: String = {s"$skillName \n$skillDesc \nAt Skill Rank : $skillRank\n"}
  }

  class Furry extends Ability(skillName = "Furry" ,skillDesc = "You Get Very Mad")

  class WildShape extends Ability(skillName = "Wild Shape" ,skillDesc = "You Turn Into An Animal")

}
