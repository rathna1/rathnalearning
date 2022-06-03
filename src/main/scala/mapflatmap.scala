object mapflatmap extends App{

  val list =List(1,2,3,4)
  println(list.head)

  println(list.map(_+1))

  println(list.filter(_%2==0))

  val numbers= List(1,2,3,4)

  val alphabets = List("a","b","c")

  val colors = List("black","white")

  alphabets.flatMap(a=>numbers.map(n=> n+a))

  val numberalpha = numbers.flatMap(n => alphabets.map(c => c+n))

  val final1 = numbers.flatMap(n=> alphabets.flatMap(a => colors.map(c => c+a+n)))
    println(final1)

  list.foreach(println)


  val forcombinations = for {

    n <- numbers if n % 2 ==0

    c <- alphabets

    co <- colors
  } yield c+n+co

 println(forcombinations)


  for {
    n <- numbers
  } println(n)


  list.map(x=>x+2)
}
