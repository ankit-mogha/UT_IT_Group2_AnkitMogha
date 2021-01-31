name := "UT-IT-Assignment"

version := "0.1"

scalaVersion := "2.13.4"

lazy val Question12 = (project in file ("Question12")).settings(libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test

  , libraryDependencies +="org.mockito" %% "mockito-scala" % "1.5.12" % Test)

lazy val Question3 = (project in file ("Question3")).settings(libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test

  , libraryDependencies +="org.mockito" %% "mockito-scala" % "1.5.12" % Test)

lazy val UTITAssignment = (project in file (".")) .aggregate(Question12,Question3)


