import sbt.Keys.{libraryDependencies, scalaVersion}

lazy val commonSettings = Seq(
  scalaVersion := "2.13.4",
    libraryDependencies ++= Seq(
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
    "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
    "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC13"
  )
)

lazy val shouldIBringUmbrella = project
  .in(file("."))
  .aggregate(common)
  .dependsOn(common)
  .settings(
    name := "ShouldIBringUmbrella",
    commonSettings
  )

lazy val common = project
  .in(file("common"))
  .settings(
    name := "common",
    commonSettings
  )