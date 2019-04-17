package controllers

import com.google.inject.Inject
import play.api.Environment
import play.api.mvc.{Action, AnyContent, Controller}
import services.StubDataService

class CharacterController @Inject()(val env: Environment) extends Controller with StubDataService {

  def all: Action[AnyContent] = Action {
    handleResource("/data/all.json") {
      Ok(_)
    }
  }

  def getCharacter(id: String): Action[AnyContent] = Action {
    handleResource(s"/data/characters/character-$id.json") {
      Ok(_)
    }
  }
}
