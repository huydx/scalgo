version := "0.1-SNAPSHOT"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.10.4", "2.11.1")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-optimise")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.5.1",
  "org.apache.spark" %% "spark-mllib" % "1.5.1",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.5.1",
  "org.apache.spark" %% "spark-streaming" % "1.5.1",
  "io.argonaut" %% "argonaut" % "6.1"
)

