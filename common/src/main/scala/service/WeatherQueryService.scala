package service

import proto.weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import proto.weatherQuery.WeatherQueryResponse.WeatherQueryResponse
import proto.weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc.WeatherQueryServer

import scala.concurrent.{ExecutionContext, Future}

class WeatherQueryService(queryService: QueryService)(implicit ec: ExecutionContext) extends WeatherQueryServer {
  override def queryWeather(request: WeatherQueryRequest): Future[WeatherQueryResponse] = queryService.query(request)
}
