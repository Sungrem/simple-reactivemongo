/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.mongo.json

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID

class BsonObjectIdFormatsSpec extends WordSpec with Matchers with PropertyChecks {

  "Serialize and deserialize a BSONObjectId to JSON" in {
    val idGen: Gen[BSONObjectID] = Gen.numChar.map(_ => reactivemongo.bson.BSONObjectID.generate())

    import BSONObjectIdFormats._

    forAll(idGen) { id =>
      val serialized   = Json.toJson(id)
      val deserialized = serialized.validate[BSONObjectID]

      deserialized.isSuccess shouldBe true
      deserialized.get       shouldBe id
    }
  }
}
