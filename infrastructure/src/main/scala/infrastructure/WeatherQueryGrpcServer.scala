package infrastructure

import io.grpc.{Server, ServerBuilder}
import proto.weatherQuery.WeatherQueryRequest.WeatherQueryRequest
import proto.weatherQuery.WeatherQueryResponse.WeatherQueryResponse
import proto.weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc
import proto.weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc.WeatherQueryServer

import scala.concurrent.{ExecutionContext, Future}

class MyWeather() extends WeatherQueryServer {
  override def queryWeather(request: WeatherQueryRequest): Future[WeatherQueryResponse] = Future.successful(WeatherQueryResponse("aaa"))
}

class WeatherQueryGrpcServer(ec: ExecutionContext, weatherQueryServer: WeatherQueryServer) { self =>
  private[this] var server: Server = null


  def start(): Unit = {
    server = ServerBuilder.forPort(8090)
      .addService(WeatherQueryServerGrpc.bindService(new MyWeather, ec))
      .build()
      .start()
  }

  def blockUntilShutdown(): Unit =
    if (server != null) {
      server.awaitTermination()
    }
}
