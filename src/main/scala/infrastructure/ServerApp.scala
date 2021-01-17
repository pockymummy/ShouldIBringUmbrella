package infrastructure

import simpleWeatherQueryConnector.service.common.SimpleInitializationService
import weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc

import scala.concurrent.ExecutionContext

object ServerApp extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val simpleService = SimpleInitializationService.load()
  val grpcService = WeatherQueryServerGrpc.bindService(new WeatherQueryServerImpl(simpleService), ec)
}
