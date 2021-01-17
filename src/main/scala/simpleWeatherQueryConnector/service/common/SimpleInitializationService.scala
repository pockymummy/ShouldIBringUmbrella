package simpleWeatherQueryConnector.service.common

import common.WeatherQueryService
import simpleWeatherQueryConnector.service.query.SimpleQueryService

import scala.concurrent.ExecutionContext

object SimpleInitializationService {
  def load()(implicit ec: ExecutionContext): WeatherQueryService = {
    val simpleHttpService = new SimpleHttpServiceImpl()
    val simpleQueryService = new SimpleQueryService(simpleHttpService)
    new WeatherQueryService(simpleQueryService)
  }
}
