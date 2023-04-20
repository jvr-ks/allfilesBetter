ThisBuild / organization := "de.jvr"
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version      := "1.00"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = (project in file("."))
.settings(
	name := "allfilesBetter",
	Compile / mainClass := Some("de.jvr.AllfilesBetter"),
	fork := false,
	logLevel := Level.Warn,
	scalacOptions ++= Seq("-deprecation", "-feature", "-language:postfixOps","-Ywarn-unused","-Yrangepos"),

	libraryDependencies ++= Seq(
		"com.github.pathikrit" %% "better-files" % "latest.integration"
	),
	
	assembly / assemblyJarName := "allfilesbetter.jar",
	assembly / assemblyMergeStrategy := {
	 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
	 case x => MergeStrategy.first
	}
	
)


  
  
    
  
  
  