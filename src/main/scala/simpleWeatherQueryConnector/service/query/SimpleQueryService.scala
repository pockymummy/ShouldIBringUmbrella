package simpleWeatherQueryConnector.service.query

import common.QueryService
import simpleWeatherQueryConnector.service.common.SimpleHttpService
import weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import weatherQuery.WeatherQueryResponse.WeatherQueryResponse

import scala.concurrent.{ExecutionContext, Future}

class SimpleQueryService(simpleConnector: SimpleHttpService) extends QueryService{
  override def query(request: WeatherQueryRequest)(implicit ec: ExecutionContext): Future[WeatherQueryResponse] = {
    val rawResponse = simpleConnector.simpleQuery()
    val wrappedResponse = WeatherQueryResponse(rawResponse)
    Future(wrappedResponse)
  }

}
