lazy val root = (project in file("."))
  .settings(
    name         := "hepek-play-example",
    organization := "ba.sake",
    scalaVersion := "3.3.1",
    libraryDependencies += guice,
    //libraryDependencies += "ba.sake" %% "hepek-play-2_9" % "0.22.0"
    libraryDependencies += "ba.sake" %% "hepek-play-3_0" % "0.22.0"
  )
  .enablePlugins(PlayScala)
