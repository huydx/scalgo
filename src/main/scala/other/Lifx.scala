package other

object Lifx {
//  trait Bytable { def tobyte(): Array[Byte] }
//
//  case class Header(frame: Frame, frameAdress: FrameAddress, protocolHeader: ProtocolHeader, payload: Array[Byte]) extends Bytable {
//    override def tobyte(): Array[Byte] = frame.tobyte & frameAdress.tobyte & protocolHeader.toString & payload
//  }
//
//  case class Frame(size: Short, protocol: Short, addressable: Byte, tagged: Byte, origin: Byte, source: Int) extends Bytable {
//    val length = 64 //64 bit
//    override def tobyte(): Array[Byte] = {
//      val res = size << 64 &
//                protocol << 48 &
//                addressable << 40 &
//                tagged << 32 &
//                origin << 24 &
//                source
//      res.toString.getBytes
//    }
//  }
//
//  case class FrameAddress(target: Byte, reserved: Byte, resRequired: Byte, ackRequired: Byte, blank: Byte, sequence: Byte) extends Bytable {
//    val length = 128 //128 bit
//    override def tobyte: Array[Byte] = {
//      new Array[Byte](5)
//    }
//  }
//  case class ProtocolHeader(reserved: Long, `type`: Short, reserved2: Short) {
//    val length = 96 //92 bit
//  }
//
//  object Headers {
//    def apply(header: Header): Byte = {
//      val frame = header.frame
//      val frameadd = header.frameAdress
//      val protocolheader = header.protocolHeader
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    val c = new DatagramSocket()
//    c.setBroadcast(true)
//
//    val sendData = "DISCOVER_FUIFSERVER_REQUEST".getBytes
//
//    try {
//      val packet = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 56700)
//      c.send(packet)
//      val interfaces = NetworkInterface.getNetworkInterfaces
//      while(interfaces.hasMoreElements) {
//        val nwInterface = interfaces.nextElement
//        val nwAddress = nwInterface.getInetAddresses
//        while (nwAddress.hasMoreElements) {
//          //send to another interface too
//        }
//      }
//      val recvBuf = new Array[Byte](1500)
//      val receivePacket = new DatagramPacket(recvBuf, recvBuf.length)
//      c.receive(receivePacket)
//      System.out.println(s"receive data ${receivePacket.getData}")
//    } catch {
//      case ex: Exception => die("can not send broadcast data")
//    }
//
//  }
//
//  def die(message: String ="error occurred") = {
//    println(message)
//    System.exit(1)
//  }
}