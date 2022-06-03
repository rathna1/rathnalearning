object seqarraylist extends App {

  val aRange = Seq(1,2,3,4)

  println(aRange)
  println(aRange.reverse)

  println(aRange.sorted)


  val num: Seq[Int] = 1 until 10

  num.foreach(println)

  val alist = List(1,2,3)

  val prelist = 42 :: alist

  println(prelist)

  val prepost = 42 +: alist :+ 36

  // : this is always to the side of list of values

 val apples5 = List.fill(5)("apple")

  println(apples5)

}
