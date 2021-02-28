package infrastructure

import io.grpc.{Server, ServerBuilder}
import proto.weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc
import proto.weatherQuery.WeatherQueryServer.WeatherQueryServerGrpc.WeatherQueryServer


import scala.concurrent.ExecutionContext

class WeatherQueryGrpcServer(ec: ExecutionContext, weatherQueryServer: WeatherQueryServer) { self =>
  private[this] var server: Server = null


  def start(): Unit = {
    server = ServerBuilder.forPort(8090)
      .addService(WeatherQueryServerGrpc.bindService(weatherQueryServer, ec))
      .build()
      .start()
  }

  def blockUntilShutdown(): Unit =
    if (server != null) {
      server.awaitTermination()
    }
}
