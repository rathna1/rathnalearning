package sparkessentials

object scalarecap extends App{

  //values and variables

val aboolean:Boolean = false

  //expressions

  val ifexpression = if(2>3) "bigger" else "smaller"

  //instructions vs expressions

  val theUnit = println("hello scala")

  //functions

  def myfunction(x:Int) = 42

  //OOP

  class Animal

  class Dog extends Animal

  trait Carnivore {
    def eat (animal:Animal): Unit
  }

   class Crocodile extends Animal with Carnivore {
     override def eat(animal: Animal) :Unit = println("crunch")



   }


}
