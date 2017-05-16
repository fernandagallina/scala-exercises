package example

/**
  * Created by fernandagallina on 5/15/17.
  */

object ComputeTime {

  def main(args: Array[String]) {
    compute_time(BisectionMethod.main(args))
  }

  def compute_time[T](method: =>T) = {
    val firstTime = System.currentTimeMillis()
    val result = method
    val lastTime = System.currentTimeMillis()
    println("%02d:%02d".format((lastTime - firstTime)/1000, lastTime - firstTime) + " seconds")
  }
}
