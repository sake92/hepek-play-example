lazy val root = (project in file("."))
  .settings(
    name         := "hepek-play-example",
    organization := "ba.sake",
    scalaVersion := "3.3.1",
    libraryDependencies += guice,
    libraryDependencies += "ba.sake" %% "hepek-play" % "0.20.0"
  )
  .enablePlugins(PlayScala)
