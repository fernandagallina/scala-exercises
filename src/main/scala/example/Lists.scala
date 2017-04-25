package example

/**
  * Created by fernandagallina on 4/25/17.
  */


object Lists {
  def sum(xs: List[Int]): Int = xs match {
    case Nil => 0
    case head :: tail => head + sum(tail)
  }

  def max(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new NoSuchElementException("The list should not be empty")
    def maxAux(xs: List[Int], maxValue: Int): Int = {
      xs match {
        case x :: tail =>
          val newMax = if (x > maxValue) x else maxValue
          maxAux(tail, newMax)
        case Nil => maxValue
      }
    }
    maxAux(xs, xs.head)
  }

  val sum1: List[Int] => Int = {
    case head :: Nil => head
    case head :: tail => head + sum1(tail)
  }

  def newSum = sum1
}
