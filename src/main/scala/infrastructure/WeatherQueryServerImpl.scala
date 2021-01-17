package infrastructure

import weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import weatherQuery.WeatherQueryResponse.WeatherQueryResponse
import weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc.WeatherQueryServer

import scala.concurrent.Future

class WeatherQueryServerImpl(weatherQueryService: WeatherQueryServer) extends WeatherQueryServer {
  override def queryWeather(request: WeatherQueryRequest): Future[WeatherQueryResponse] = weatherQueryService.queryWeather(request)
}
