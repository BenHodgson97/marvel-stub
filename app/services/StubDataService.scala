package services

import java.io.InputStream

import play.api.{Environment, Play}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Result, Results}

import scala.io.Source

trait StubDataService extends Results {

  val env: Environment

  private def readStreamToString(is: InputStream): String = {
    try Source.fromInputStream(is).mkString.toString
    finally is.close()
  }

  def handleResource(resourcePath: String)(f: JsValue => Result): Result = {
    val resource = env.resourceAsStream(resourcePath)
    resource.fold[Result](ifEmpty = NotFound){
      stream =>
        f(Json.parse(readStreamToString(stream)))
    }
  }

}
