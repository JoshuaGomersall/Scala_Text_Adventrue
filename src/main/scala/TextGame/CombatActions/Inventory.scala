package TextGame.CombatActions


object Inventory {
  val equipt: List[String] = List[String]()
  val backpack: List[String] = List("sword")

  def addItemToBackPack(itemToAdd: String): List[String] = {
    println(s"Adding Item $itemToAdd To BackPack")
    backpack :+ itemToAdd
  }

  def equiptItem(itemToEquipt: String):List[String]= {
    println(backpack.toString())

    if (backpack.contains(itemToEquipt) && !equipt.contains(itemToEquipt)){
      println(s"Backpack : $backpack \nEquipt: $equipt")
      return equipt :+ itemToEquipt
    }
    else if (equipt.contains(itemToEquipt)) {
      println(s"You Seem To Have $itemToEquipt Equipt Already")
    }
    else {
      println(s"You Dont Seem To Have The Item $itemToEquipt ")
    }
    equipt
  }

  def displayEquipt(): String ={
    equipt.toString()
  }

  def displayBackPack(): String ={
    backpack.toString()
  }


  class EquiptItems(var head: String = "", var torso: String = "", var leftHand: String = "",var rightHand: String ,var leftLeg: String ,var  rightLeg: String) {
    override def toString: String = s"You Have $head \n$torso \n$leftHand \n$rightHand \n$leftLeg \n$rightLeg "
  }
}
