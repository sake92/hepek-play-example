
name := """play-hepek-example"""
organization := "ba.sake"
version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += guice

libraryDependencies += "ba.sake" %% "hepek-play" % "0.7.0+12-0b83e9ff-SNAPSHOT" changing ()

resolvers += Resolver.sonatypeRepo("snapshots")
