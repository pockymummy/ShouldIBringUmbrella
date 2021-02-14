package simpleWeatherQueryConnector.service.query

import proto.weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import proto.weatherQuery.WeatherQueryResponse.WeatherQueryResponse
import service.QueryService
import simpleWeatherQueryConnector.service.common.SimpleHttpService

import scala.concurrent.{ExecutionContext, Future}

class SimpleQueryService(simpleConnector: SimpleHttpService) extends QueryService{
  override def query(request: WeatherQueryRequest)(implicit ec: ExecutionContext): Future[WeatherQueryResponse] = {
    val rawResponse = simpleConnector.simpleQuery()
    val wrappedResponse = WeatherQueryResponse(rawResponse)
    Future(wrappedResponse)
  }

}
