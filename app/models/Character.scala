package models

import play.api.libs.json.{Format, Json}


case class Characters(characters: List[Character])

object Characters {
  implicit val formats: Format[Characters] = Json.format[Characters]
}

case class CharacterFull(
                    id: String,
                    name: String = "Unknown",
                    alias: Option[String] = None,
                    age: Option[Int] = None,
                    powers: List[String],
                    deceased: Boolean
                    )

object CharacterFull {
  implicit val formats: Format[CharacterFull] = Json.format[CharacterFull]
}


case class Character(
                    id: String,
                    name: String
                    )

object Character {
  implicit val formats: Format[Character] = Json.format[Character]
}