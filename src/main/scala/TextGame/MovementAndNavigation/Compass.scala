package TextGame

import scala.math.{pow, sqrt}

object Compass {
  def compassMain(xPlayer: Int, xExit: Int, xEvent: Int, yPlayer: Int, yExit: Int, yEvent: Int): Unit  = {
    if (sqrt(pow(xPlayer - xExit, 2) + pow(yPlayer - yExit, 2)) < sqrt(pow(xPlayer - xEvent, 2) + pow(yPlayer - yEvent, 2))) {
      println(s"The Compass Is Pointing " + sqrt(pow(xPlayer - xExit, 2) + pow(yPlayer - yExit, 2)) + "m")
    }
    else {
      println(s"The Compass Is Pointing " + sqrt(pow(xPlayer - xEvent, 2) + pow(yPlayer - yEvent, 2)) + "m")
    }
  }
}
