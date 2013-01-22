package test.scala

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import scala.collection.mutable.Stack
import org.scalatest.prop.TableDrivenPropertyChecks

class MultiplicationSpec extends FeatureSpec with GivenWhenThen {

  feature("Multiplication") {

    info(" In order to avoid making mistakes")
    info("As an accountant")
    info(" I want to multiply numbers")

    scenario("Multiply two variables") {

      given("a variable x with value 3")
      val x = 3
      and("a variable y with value 4")
      val y = 4

      when("i multiply x * y")
      val result = x * y

      then("i get 12")
      assert(result === 11)

    }

  }
}
