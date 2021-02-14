package service

import proto.weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import proto.weatherQuery.WeatherQueryResponse.WeatherQueryResponse

import scala.concurrent.{ExecutionContext, Future}

trait QueryService {
  def query(request: WeatherQueryRequest)(implicit ec: ExecutionContext): Future[WeatherQueryResponse]
}
