package example

/**
  * Created by fernandagallina on 5/8/17.
  */

object BisectionMethod {

  def main(args: Array[String]) {
    driver
  }

  def bisectionMethod(fx: (Double) => Double, left: Double, right: Double, tolerance: Double) : Double = {
    if(math.abs(right - left) < tolerance) return (left + right) / 2
    else {
      val x = (left + right) / 2
      println("Root:" + x)
      println("Estimated error:" + (right - left))
      if(fx(left) * fx(x) > 0) return bisectionMethod(fx, x, right, tolerance)
      else return bisectionMethod(fx, left, x, tolerance)
    }
  }

  def driver {
    val fx = (x: Double) => math.pow(x, 3) - x - 2
    val left = 1
    val right = 2
    val tolerance = 0.0005
    val answer = bisectionMethod(fx, left, right, tolerance)
    println(answer)
  }
}
