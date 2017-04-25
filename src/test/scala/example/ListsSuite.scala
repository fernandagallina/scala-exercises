package example

/**
  * Created by fernandagallina on 4/25/17.
  */

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  test("one plus one is two")(assert(1 + 1 == 2))

  test("one plus one is three?") {
    assert(1 + 1 != 3)
  }

  test("details why one plus one is not three") {
    assertResult(false) {
      1 + 1 === 3
    }
  }

  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }

  import Lists._

  test("sum of a few numbers") {
    assert(sum(List(1,2,0)) === 3)
  }

  test("max of a few numbers") {
    assert(max(List(3, 7, 2)) === 7)
  }

  test("sum with negative number") {
    assert(sum(List(-1,2,3,-4)) === 0)
  }

  test("sum with empty list") {
    assert(sum(List()) === 0)
  }

  test("max of equal numbers") {
    assert(max(List(1,2,5,3,4,3,5)) === 5)
  }

  test("max of empty list") {
    intercept[NoSuchElementException] {
      max(List())
    }
  }

  test("max of negative number") {
    assert(max(List(-1,-2,-3,-4)) === -1)
  }
}
