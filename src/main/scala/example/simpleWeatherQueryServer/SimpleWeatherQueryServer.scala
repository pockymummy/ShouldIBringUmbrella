package example.simpleWeatherQueryServer

import example.hello.GreeterGrpc
import io.grpc.{Server, ServerBuilder}

import scala.concurrent.ExecutionContext

object SimpleWeatherQueryServer extends App {
  val server = new SimpleWeatherQueryServer(ExecutionContext.global)
  server.start()
  server.blockUntilShutdown()
}

class SimpleWeatherQueryServer(ec: ExecutionContext) {self =>

  private[this] var server: Server = null

  private def start(): Unit = {
    val simpleWeatherApiQueryService = new SimpleWeatherApiQueryServiceImpl
    server = ServerBuilder.forPort(8090)
      .addService(GreeterGrpc.bindService(new SimpleWeatherQueryService(simpleWeatherApiQueryService), ec))
      .build()
      .start()
  }

  private def blockUntilShutdown(): Unit =
    if (server != null) {
      server.awaitTermination()
    }

}
