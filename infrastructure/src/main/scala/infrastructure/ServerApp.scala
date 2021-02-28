package infrastructure

import simpleWeatherQueryConnector.service.common.SimpleInitializationService

import scala.concurrent.ExecutionContext

object ServerApp extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val simpleService = SimpleInitializationService.load()
  val implementedGrpcServerService = new WeatherQueryServerImpl(simpleService)
  val server = new WeatherQueryGrpcServer(ec,implementedGrpcServerService)

  server.start()
  server.blockUntilShutdown()
}
