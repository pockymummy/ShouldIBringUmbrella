import sbt.Keys.scalaVersion

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value / "scalapb"
)

lazy val shouldIBringUmbrella = project
  .in(file("."))
  .settings(
    name := "ShouldIBringUmbrella",
    scalaVersion := "2.13.4"
  )

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
  "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC13"
)