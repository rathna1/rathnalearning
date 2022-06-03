object ifstat1 extends App {

  val list100 = List.range(1 , 100)

  val list1=List.range(1,20)


  println(list1.map(e=>if (e%3==0) "3" else if(e%5==0) "5" else e))



  /*
  val r = 1 to 10 by 2
  println(r)
  println(list100)


  val listempty = List()

  for (i <- 0 to list100.length) {
    if (i % 3 == 0) {


      list100(i) = "rathna"
      listempty = listempty :+ list100(i)

    }
    else {
       listempty = listempty :+ list100(i)
    }

  }

*/

}


/*

  object Scala_List {
    def Nth_num[A](nums: List[A], n: Int): A = {
      if (n < 0) throw new IllegalArgumentException("Nth position is less than 1!")
      if (n > nums.length) throw new NoSuchElementException("Nth position greater than list length!")
      nums(n)
    }

    def main(args: Array[String]): Unit = {
      val nums = List(10, 20, 30, 40, 50, 70, 90, 110, 140, 120, 160)
      println("Original list:")
      println(nums)
      println("3rd element of the said element: " + Nth_num(nums, 2));
      println("6th element of the said element: " + Nth_num(nums, 5));
      println("1st element of the said element: " + Nth_num(nums, 0));
    }
 */