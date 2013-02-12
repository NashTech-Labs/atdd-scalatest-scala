package test.scala

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen
import scala.compat.Platform

class MultiplicationSpecWithGenerators extends FeatureSpec with GivenWhenThen with GeneratorDrivenPropertyChecks {


  val validNumberOnes = for (n <- Gen.choose(-10, 300)) yield n
  val validNumberTwos = for (n <- Gen.choose(10, 15)) yield n
  
  feature("Multiplication") {

    info(" In order to avoid making mistakes")
    info("As an accountant")
    info(" I want to multiply numbers")

    scenario("Multiply two variables") {
      forAll(validNumberOnes, validNumberTwos, minSuccessful(500), maxDiscarded(30), workers(4)) {
        (x: Int, y: Int) =>
          given("a variable x with value " + x)
          and("a variable y with value " + y)

          when("i multiply " + x +" and " + y)
          val expectedResult = (x * y)
          assert((new ActualBusinessImplementation).actualMultiply(x, y) === expectedResult.toInt)
          then("i get " + expectedResult)
      }
    }

  }
}

/**
 * Actual Software Under Test
 */
class ActualBusinessImplementation{
  def actualMultiply(a:Int, b:Int) = a * b
}
