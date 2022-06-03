import scala.concurrent.duration.DurationConversions

object tuplesmaps extends App {


 val atuple = Tuple2(2,"rathna")

 println(atuple)


 //maps are key ->value

 val mapfunc: Map[String,Int] = Map()

 val Phonebook = Map(("RATHNA",999),("PRANAY",555)).withDefaultValue(-1)

 val Phonebook1 = Map(("RATHNA",666),"PRANAY"-> 999)

 println(Phonebook)

 println(Phonebook.contains("JIM"))

 println(Phonebook("JIM"))

 // add a new pairing

 val newpair = "charan"-> 666

 val newPhonebook = Phonebook + newpair

 println(newPhonebook)

 //functionsals on map
 //map , flatmap , filter

 val lowercasephonebook = Phonebook.map(x=>x._1.toLowerCase()->x._2)
 println(lowercasephonebook)
 val lowercasephone = Phonebook.map(x=>x._1.toLowerCase())
 println(lowercasephone)

 println(Phonebook.filterKeys(_.startsWith("R")))

 //MAPVALUES


 println(Phonebook.mapValues(x=>x*10))

 //Conversions

 println(Phonebook.toList)

 println(List(("MURALI",999)).toMap)

 val names = List("RATHNA", "PRIYA", "PREMIA", "PREMA", "CHARAN", "PUJYA")

 println(names)

 println(names.groupBy(x=>x.charAt(0)))

 val phone = Map(("Jim"->555),("JIM"->777))

 val lowerphone = phone.map(x=>x._1.toLowerCase->x._2)
println(lowerphone)

}


