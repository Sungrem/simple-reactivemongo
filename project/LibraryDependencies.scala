import sbt._

object LibraryDependencies {

  private val play25Version = "2.5.12"
  private val play26Version = "2.6.15"

  val compile: Seq[ModuleID] = PlayCrossCompilation.dependencies(
    shared = Seq(
      "com.github.nscala-time" %% "nscala-time"   % "2.2.0",
      "org.reactivemongo"      %% "reactivemongo" % "0.16.0"
    ),
    play25 = Seq(
      "org.slf4j"         % "slf4j-api"                % "1.7.6",
      "com.typesafe.play" %% "play"                    % play25Version,
      "com.typesafe.play" %% "play-json"               % "2.5.16",
      "org.reactivemongo" %% "reactivemongo-play-json" % "0.16.0-play25"
    ),
    play26 = Seq(
      "org.slf4j"         % "slf4j-api"                % "1.7.25",
      "com.typesafe.play" %% "play"                    % play26Version,
      "com.typesafe.play" %% "play-guice"              % play26Version,
      "com.typesafe.play" %% "play-json"               % "2.6.9",
      "org.reactivemongo" %% "reactivemongo-play-json" % "0.16.0-play26"
    )
  )

  val test: Seq[ModuleID] = PlayCrossCompilation.dependencies(
    shared = Seq(
      "com.outworkers" %% "util-samplers" % "0.40.0" % Test,
      "org.pegdown"    % "pegdown"        % "1.6.0"  % Test,
      "org.scalacheck" %% "scalacheck"    % "1.13.4" % Test,
      "org.scalamock"  %% "scalamock"     % "4.1.0"  % Test,
      "org.scalatest"  %% "scalatest"     % "3.0.5"  % Test
    ),
    play25 = Seq(
      "ch.qos.logback"         % "logback-classic"     % "1.1.2"       % Test,
      "com.typesafe.play"      %% "play-test"          % play25Version % Test,
      "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.1"       % Test
    ),
    play26 = Seq(
      "ch.qos.logback"         % "logback-classic"     % "1.2.3"       % Test,
      "com.typesafe.play"      %% "play-test"          % play26Version % Test,
      "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2"       % Test
    )
  )
}
