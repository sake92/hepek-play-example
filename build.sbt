
name := """play-hepek-example"""
organization := "ba.sake"
version := "1.0-SNAPSHOT"

scalaVersion := "2.12.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test

libraryDependencies += "ba.sake" %% "hepek-play" % "0.4.0+36-5fc33a7f-SNAPSHOT" changing ()

resolvers += Resolver.sonatypeRepo("snapshots")
