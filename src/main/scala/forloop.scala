object forloop extends App{

  val list1=List(1,34,3,4,31,6,67,8,9,10,23)

  val evennumbers=list1.filter(_%2==0)

  println(evennumbers)



/*
  val listElements = List.range(1, 20, 3)
  println(listElements)

  var evenPositionList = List.empty[Int]
  var oddPositionList = List.empty[Int]
  var thirdPostionList = List.empty[Int]
  var FourthPostionList = List.empty[Int]

  for (li <- 0 to listElements.length; if li < listElements.length) {
    if (li % 2 == 0) {
      evenPositionList = evenPositionList :+ listElements(li)
    }



    if (li % 2 == 1) {
      oddPositionList = oddPositionList :+ listElements(li)
    }



    if (li > 0 && li % 3 == 0) {
      thirdPostionList = thirdPostionList :+ listElements(li - 1)
    }



    if (li > 0 && li % 4 == 0) {
      FourthPostionList = FourthPostionList :+ listElements(li - 1)
    }
  }

*/
}
