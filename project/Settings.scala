import sbt._
import sbt.Keys._
import sbtassembly.AssemblyKeys._
import sbtassembly.{MergeStrategy, PathList}


object Settings extends Build {
  lazy val buildSettings = Seq(
    name := "scalgo",
    organization := "some organization",
    scalaVersion := Versions.Scala,
    parallelExecution := true,
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
      case PathList("reference.conf") => MergeStrategy.concat
      case _ => MergeStrategy.first
    }
  )

  override lazy val settings = super.settings ++ buildSettings
}
