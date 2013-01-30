package test.scala

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import scala.collection.mutable.Stack
import org.scalatest.prop.TableDrivenPropertyChecks

class MultiplicationSpecWithTable extends FeatureSpec with GivenWhenThen with TableDrivenPropertyChecks {

  val numbersToMultiply = Table(("Number1", "Number2", "Result"), ("3", "4", "12"), ("5", "6", "30"), ("7", "8", "56"))

  feature("Multiplication") {

    info(" In order to avoid making mistakes")
    info("As an accountant")
    info(" I want to multiply numbers")

    scenario("Multiply two variables") {
      forAll(numbersToMultiply) {
        (x: String, y: String, expectedResult: String) =>
          given("a variable x with value " + x)
          and("a variable y with value " + y)

          when("i multiply " + x +" and " + y)
          val actualResult = x.toInt * y.toInt

          then("i get " + expectedResult)
          assert(actualResult === expectedResult.toInt)
      }

    }

  }
}
