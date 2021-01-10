package example.helloWorld

import example.hello.{GreeterGrpc, HelloReply, HelloRequest}

import scala.concurrent.Future

class GreetingService extends GreeterGrpc.Greeter {
  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    val reply = HelloReply(message = "Hello " + request.name)
    Future.successful(reply)
  }
}