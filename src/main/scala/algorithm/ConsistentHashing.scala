package algorithm

import java.security.{MessageDigest, NoSuchAlgorithmException}

import scala.io.Source

/*
implementation of consistent hashing algorithm which oftenly use in
caching or memcache server searching
 */
object ConsistentHashing {
  var bucket: java.util.TreeMap[Long, String] = null

  def apply(serverFile: String): Unit = {
    bucket = new java.util.TreeMap[Long, String]()

    //add server to continuum
    lazy val s = Source.fromFile( serverFile )
    try {
      for (line <- s.getLines()) {
        val h = ketamaHash(line)
        bucket.put(h, line)
      }
    } finally {
      s.close()
    }
  }

  def findServerFor(key: String): Option[String] = {
    if (bucket.isEmpty) {
      println("server not found")
      return None
    }

    val h = ketamaHash(key)
    if (!bucket.containsKey(h)) {
      val ret: java.util.SortedMap[Long, String] = bucket.tailMap(h)
      val foundHash = if (ret.isEmpty) {
        bucket.firstKey()
      } else {
        ret.firstKey()
      }
      Some(bucket.get(foundHash))
    } else {
      Some(bucket.get(h))
    }
  }

  def ketamaHash(in: String): Long = {
    try {
      val md5 = MessageDigest.getInstance("MD5")
      md5.reset()
      md5.update(in.getBytes)

      val bKey: Array[Byte] = md5.digest()

      val res: Long =
        (bKey(3) & 0xFF << 24 ).asInstanceOf[Long] |
        (bKey(2) & 0xFF << 16 ).asInstanceOf[Long] |
        (bKey(1) & 0xFF <<  8 ).asInstanceOf[Long] |
        (bKey(0) & 0xFF       ).asInstanceOf[Long]

      res
    } catch {
      case ex: NoSuchAlgorithmException => throw ex
    }
  }
}

object Boot extends App {
  ConsistentHashing("/tmp/server.txt")
  println(ConsistentHashing.findServerFor("121312313"))
  println(ConsistentHashing.findServerFor("121312353"))
  println(ConsistentHashing.findServerFor("121312323"))
  println(ConsistentHashing.findServerFor("121311113"))
  println(ConsistentHashing.findServerFor("999999993"))
}
