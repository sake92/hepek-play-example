
name := """play-hepek-example"""
organization := "ba.sake"
version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += guice

libraryDependencies += "ba.sake" %% "hepek-play" % "0.6.0+39-d9306b48-SNAPSHOT" changing ()

resolvers += Resolver.sonatypeRepo("snapshots")
