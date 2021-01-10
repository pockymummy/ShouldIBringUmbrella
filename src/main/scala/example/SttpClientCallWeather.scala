package example

import sttp.client3.{HttpURLConnectionBackend, UriContext, basicRequest}

object SttpClientCallWeather extends App {
  val parameters = Map("lat" -> "13.745890", "lon" -> "100.538807", "exclude" -> "daily,minute", "appid" -> "739c8ef7068e5b553b1e08219ce008d4")
  val myRequest = basicRequest
    .get(uri"https://api.openweathermap.org/data/2.5/onecall?$parameters")
  val backend = HttpURLConnectionBackend()
  val response = myRequest.send(backend)
  println(response.body)
}
