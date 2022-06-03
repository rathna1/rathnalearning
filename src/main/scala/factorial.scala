object factorial extends App {

  def findfact(n: Int): Int = {

    if (n <= 1) 1
    else {
      val factcal = n * findfact(n - 1)
      factcal

    }

  }
  println(findfact(4))


  def facttail(n:Int , acc: Int =1): Int = {

    if (n <= 1) acc
    else {
      facttail(n-1, n *acc )
    }
  }

  println(facttail(4))


  // concatenate rathna 4 times

}
