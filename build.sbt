lazy val root = (project in file("."))
  .settings(
    name         := "hepek-play-example",
    organization := "ba.sake",
    scalaVersion := "3.3.1",
    libraryDependencies += guice,
    libraryDependencies += "ba.sake" %% "hepek-play" % "0.19.0+5-58600164+20231207-1056-SNAPSHOT"
  )
  .enablePlugins(PlayScala)
