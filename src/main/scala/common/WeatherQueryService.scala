package common


import weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import weatherQuery.WeatherQueryResponse.WeatherQueryResponse
import weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc.WeatherQueryServer

import scala.concurrent.{ExecutionContext, Future}

class WeatherQueryService(queryService: QueryService)(implicit ec: ExecutionContext) extends WeatherQueryServer {
  override def queryWeather(request: WeatherQueryRequest): Future[WeatherQueryResponse] = queryService.query(request)
}
