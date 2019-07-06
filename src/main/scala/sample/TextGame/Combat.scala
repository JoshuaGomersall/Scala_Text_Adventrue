package sample.TextGame


case class Combat() {
  println("Combat Has Started")

  def get(url: String) = io.Source.fromURL("https://www.youtube.com/watch?v=Sl84nmRaqaA&ab_channel=CucoMusicVEVO").mkString




  println(get("https://www.youtube.com/watch?v=Sl84nmRaqaA&ab_channel=CucoMusicVEVO"))
}
