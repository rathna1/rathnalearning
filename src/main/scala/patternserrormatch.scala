object patternserrormatch extends App{
  try
  {
   // code
  }
    catch {
      case e: RuntimeException => "runtime exception"
      case npe: NullPointerException =>"npe"
      case _ => "Something"
    }


  val list = List(1,2,3,4,5)

  val listeven =list.filter(_%2==0)

  val multiplyby10 = listeven.map(_*10)

  println(multiplyby10)



  val list1=List(1,2,3,4,5)
  val evennumber = for {
    x <- list1 if x%2 == 0
  } yield 10*x

  println(evennumber)

  val tuple = (1,2,3)
  val (a,b,c) =tuple


  val list3 = List(1,2,3,4,5)
  val mappedList = list3.map  {

    case v if v % 2 == 0 => v + "is even"

    case _ => "something"
  }


  val list4 =List(1,2,3,4,5)

  val maplist = list.map {x=> x match {
    case v if v % 2 == 0 => v + "is even"

    case _ => "something"

  }}
}

/*

try {
 code
 }

 catch (e)

 e match {

   case e: RuntimeException => "runtime exception"
      case npe: NullPointerException =>"npe"
      case _ => "Something"

 }
 */