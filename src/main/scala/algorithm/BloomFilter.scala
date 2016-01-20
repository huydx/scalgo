package algorithm

import java.util
import java.util.{Random, BitSet}

object BloomFilter {
  val NUM_HASH = 6
  val PAGE_SIZE = 65536

  def apply(numEntries: Int, fpProb: Double, seed: Int = 0): BloomFilterImpl = {
    val bitSize = optimalWidth(numEntries, fpProb)
    val numHashes = optimalNumHashes(numEntries, bitSize)
    new BloomFilterImpl(bitSize, numHashes)
  }

  def optimalNumHashes(numEntries: Int, width: Int): Int = math.ceil(width/numEntries * math.log(2)).toInt
  def optimalWidth(numEntries: Int, fpProb: Double): Int = {
    val widthEstimate = math.ceil(-1 * numEntries * math.log(fpProb) / math.log(2) / math.log(2)).toInt
    if (widthEstimate == Int.MaxValue) {
      throw new java.lang.IllegalArgumentException(
        "BloomFilter cannot guarantee the specified false positive probability for the number of entries!")
    }
    widthEstimate
  }
}

case class BloomFilterImpl(bitSize: Int, numHashes: Int) {
  require(bitSize > 0)
  require(numHashes > 0)
  val bitSet = new util.BitSet(bitSize)

  def clear() = {
    for (i <- 0 until bitSize) bitSet.set(i, true)
  }

  def add(item: String) = {
    val rand = new Random(item.hashCode)
    for (i <- 0 until numHashes) bitSet.set(rand.nextInt(bitSize), true)
  }

  def query(item: String): Boolean = {
    val rand = new Random(item.hashCode)
    for (i <- 0 until numHashes) {
      if (!bitSet.get(rand.nextInt(bitSize))) return false
    }
    true
  }
}

object TestBloomFilter {
  def main(args: Array[String]): Unit = {
    val filter = BloomFilter(100, 0.1)
    filter.add("foo")
    filter.add("bar")
    filter.add("zzzz")

    assert(filter.query("foo"))
    assert(!filter.query("asdadasdada"))
  }
}
