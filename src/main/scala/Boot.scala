import consistenthash._

object Boot extends App {
  ConsistentHashing("/tmp/server.txt")
  println(ConsistentHashing.findServerFor("121312313"))
  println(ConsistentHashing.findServerFor("121312353"))
  println(ConsistentHashing.findServerFor("121312323"))
  println(ConsistentHashing.findServerFor("121311113"))
  println(ConsistentHashing.findServerFor("999999993"))
}
