
name := """play-hepek-example"""
organization := "ba.sake"
version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test

libraryDependencies += "ba.sake" %% "hepek-play" % "0.6.0+37-1b866ce1+20200328-1847-SNAPSHOT" changing ()

resolvers += Resolver.sonatypeRepo("snapshots")
