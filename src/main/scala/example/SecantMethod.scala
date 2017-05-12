package example

/**
  * Created by fernandagallina on 5/12/17.
  */

object SecantMethod {

  def secantMethod(fx: (Double) => Double,
                   fx1Deriv: (Double) => Double,
                   x0: Double, x1: Double,
                   tolerance: Double): Double = {
    val x2 = secantMethodHelper(fx, fx1Deriv, x0, x1)
    if(math.abs((x2 - x1)/x2) > tolerance) {
      secantMethod(fx, fx1Deriv, x1, x2, tolerance)
    } else return x2
  }

  def driver {
    val fx = (x: Double) => 3 * x + math.sin(x) - math.pow(math.E, x)
    val fx1Deriv = (x: Double) => 3 + math.cos(x) - math.pow(Math.E, x)
    val initialGuess1 = -1.0
    val initialGuess2 = 7.0
    val tolerance = 0.000005
    val answer = secantMethod(fx, fx1Deriv, initialGuess1, initialGuess2, tolerance)
    println(answer)
  }

  def main(args: Array[String]): Unit = {
    driver
  }

  def secantMethodHelper(fx: (Double) => Double,
                         fx1Deriv: (Double) => Double,
                         x0: Double, x1: Double): Double = {
    ((x0 * fx(x1)) - (x1 * fx(x0))) / (fx(x1) - fx(x0))
  }
}