import scala.util.Random

object patternmatching extends App{

  val random = new Random()

  val x=random.nextInt(10)

  val description = x match {
    case 1 => "the one"
    case 2 => "the two"
    case 3 => "the three"
    case _ => "something else"

  }
  println(x)
  println(description)


  case class person(name:String, age: Int)
  val Bob = person("Bob",20)

  val greeting = Bob match {
    case person(n,a) if a < 21 => s"my name is $n and i am $a age"
    case _ => "I dont know"
  }

  sealed class Animal
  case class Dog(breed: String ) extends Animal
  case class Parrot(greeting: String ) extends Animal

  val animal:Animal = Dog("Terra Nova")

  animal match {

    case(Dog(somebreed)) => println(s" matched a DOG $somebreed")
  }


  val y:Any = "Scala"




  //match anything

  val matchanything = x match {
    case _ => "Matched"
  }

  val matchanything1 = x match {

    case something => s"I ve found $something"
  }

  //match tuples

  val atuple = (2,3)

  val matchtuple = atuple match {
    case (1,2) => "good"
      case(_,3) => "good start"
  }

  println(matchtuple)

  val list = List(1,2,3,5)

  val listmatch = list match {
    case List(1,_*) => "List starts with 1"
    case 1::List(2,3,4) =>"absolute List"
    case List(1,2,3) :+ 5 => "apppend "
  }


}
