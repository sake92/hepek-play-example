name := "play-hepek-example"

organization := "ba.sake"

scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    libraryDependencies += guice,
    libraryDependencies += "ba.sake" %% "hepek-play" % "0.19.0"
  )
  .enablePlugins(PlayScala)
