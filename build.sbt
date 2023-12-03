name := "play-hepek-example"

organization := "ba.sake"

scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    libraryDependencies += guice,
    libraryDependencies += "ba.sake" %% "hepek-play" % "0.18.0+4-97ca2ef7+20231201-1922-SNAPSHOT"
  )
  .enablePlugins(PlayScala)
