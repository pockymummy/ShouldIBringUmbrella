package common

import weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import weatherQuery.WeatherQueryResponse.WeatherQueryResponse

import scala.concurrent.{ExecutionContext, Future}

trait QueryService {
  def query(request: WeatherQueryRequest)(implicit ec: ExecutionContext): Future[WeatherQueryResponse]
}
