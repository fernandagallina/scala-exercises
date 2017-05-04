package example

object NewtonsMethod {

  def main(args: Array[String]) {
    driver
  }

  def driver {
    val fx = (x: Double) => 3 * x + math.sin(x) - math.pow(math.E, x)
    val fx1Deriv = (x: Double) => 3 + math.cos(x) - math.pow(Math.E, x)
    val initialGuess = 0.0
    val tolerance = 0.00005
    val answer = newtonsMethod(fx, fx1Deriv, initialGuess, tolerance)
    println(answer)
  }

  def newtonsMethod(fx: (Double) => Double,
                    fx1Deriv: (Double) => Double,
                    x: Double,
                    tolerance: Double): Double = {
    var x1 = x
    var xNext = newtonsMethodHelper(fx, fx1Deriv, x1)
    while (math.abs(xNext - x1) > tolerance) {
      x1 = xNext
      println(xNext)
      xNext = newtonsMethodHelper(fx, fx1Deriv, x1)
    }
    xNext
  }

  def newtonsMethodHelper(fx: (Double) => Double,
                          fx1Deriv: (Double) => Double,
                          x1: Double): Double = {
    x1 - fx(x1) / fx1Deriv(x1)
  }
}

