package net.astail.jmld

import collection.JavaConverters._
import org.jsoup._
import com.typesafe.config.ConfigFactory

object juebat {

  val cookie1 = ConfigFactory.load.getString("cookie1")
  val cookie2 = ConfigFactory.load.getString("cookie2")

  def jsoup(url: String) = {
    val result = Jsoup.connect(url).
      cookie(cookie1,cookie2).get
    for (t <- result.select("a.popup-link").asScala if t.hasText()) yield t.text()
  }

  //for (i <- 1 to 17) yield jsoup(url(i))

  def musicList(page: Int, url: Int => String): Seq[String] = {
    for {
      i <- 1 to page
      n <- jsoup(url(i))
    } yield n
  }
}