package sparkessentials

object functionalprogramming extends App {

  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1) // HOF
  val aFlatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  } // alternative syntax, same as .flatMap(x => List(x, 2 * x))
  val aFilteredList = List(1, 2, 3, 4, 5).filter(_ <= 3) // equivalent to x => x <= 3

  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above

}
