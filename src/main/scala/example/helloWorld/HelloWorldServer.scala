package example.helloWorld

import example.hello.GreeterGrpc
import io.grpc.{Server, ServerBuilder}

import scala.concurrent.ExecutionContext

object HelloWorldServer extends App {
  val server = new HelloWorldServer(ExecutionContext.global)
  server.start()
  server.blockUntilShutdown()
}

class HelloWorldServer(ec: ExecutionContext) { self =>

  private[this] var server: Server = null

  private def start(): Unit = {
    server = ServerBuilder.forPort(8090)
      .addService(GreeterGrpc.bindService(new GreetingService, ec))
      .build()
      .start()
  }

  private def blockUntilShutdown(): Unit =
    if (server != null) {
      server.awaitTermination()
    }
}