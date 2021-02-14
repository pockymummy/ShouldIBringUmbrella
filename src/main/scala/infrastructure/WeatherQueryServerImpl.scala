package infrastructure

import proto.weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import proto.weatherQuery.WeatherQueryResponse.WeatherQueryResponse
import proto.weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc.WeatherQueryServer

import scala.concurrent.Future

class WeatherQueryServerImpl(weatherQueryService: WeatherQueryServer) extends WeatherQueryServer {
  override def queryWeather(request: WeatherQueryRequest): Future[WeatherQueryResponse] = weatherQueryService.queryWeather(request)
}
