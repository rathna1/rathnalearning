object Optional extends App{

  val myFirstOption: Option[Int] = Some(4)

  val first: Int = 5

  val nooption: Option[Int] = None

  def UnsafeMethod(): String = null

  val result = Option(UnsafeMethod())

  println(result)


  def BackupMethod(): String = "A valid Result"

  val ChainedResult = Option(UnsafeMethod).orElse(Option(BackupMethod()))


  val nullvalue = None

  println(nullvalue)

  //functions on options

  println(myFirstOption.isEmpty)

  println(myFirstOption.flatMap(x=>Option(x*10)))
    println(myFirstOption.map(x=>Option(x*10)))

  println(myFirstOption.filter(x=>x > 10))




}
