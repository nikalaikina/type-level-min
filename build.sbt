ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "type-level-sorting-3",
    ThisBuild / scalacOptions += "-Ykind-projector:underscores"
  )
