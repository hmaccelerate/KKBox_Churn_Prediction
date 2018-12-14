name := "projectScala"
 
version := "1.0" 
      
lazy val `projectscala` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
//scalaVersion := "2.12.2"
scalaVersion := "2.11.7"


libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

//unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
unmanagedResourceDirectories in Test +=  baseDirectory ( _ /"target/web/public/test" ).value

libraryDependencies += guice

libraryDependencies += jdbc

libraryDependencies += evolutions

libraryDependencies += "com.h2database" % "h2" % "1.4.192"

libraryDependencies += "org.playframework.anorm" %% "anorm" % "2.6.1"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"