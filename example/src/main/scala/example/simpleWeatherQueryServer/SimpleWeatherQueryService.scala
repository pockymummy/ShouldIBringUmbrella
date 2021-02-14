package example.simpleWeatherQueryServer

import example.hello.GreeterGrpc.Greeter
import example.hello.{HelloReply, HelloRequest}

import scala.concurrent.Future

class SimpleWeatherQueryService(simpleWeatherApiQueryService: SimpleWeatherApiQueryService) extends Greeter{
  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    val reply = HelloReply(simpleWeatherApiQueryService.queryWeather())
    Future.successful(reply)
  }
}
