package net.astail.jmld

object Main {
  def main(args: Array[String]): Unit = {
    val astel = juebat.musicList(17, i => s"https://p.eagate.573.jp/game/jubeat/festo/playdata/music.html?sort=&page=${i}")

    val gune = juebat.musicList(14, i => s"https://p.eagate.573.jp/game/jubeat/festo/playdata/music.html?rival_id=60930001367638&sort=&page=${i}")

    astel diff gune foreach println
  }
}
