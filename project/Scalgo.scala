import sbt._
import sbt.Keys._

object scalgo extends Build {
  import Settings._

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = buildSettings /*++ Seq(libraryDependencies*/
  )

  object Dependencies {
    import Versions._
    object Compile {
      //sample: lazy val slf4j = "com.typesafe.akka" % "akka-slf4j_2.11" % Akka
    }

    import Compile._
    //sample: lazy val akka = Seq(slf4j, actor, akkaStream, akkaHttpCore, akkaHttp)
  }
}
