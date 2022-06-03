object add extends App {

  val add = new addnumbers(2,3)

  println(add)




  class addnumbers(n1: Int, n2: Int) {
    def addnumbers = {

     n1 + n2

    }

  }

}

// In scala we can define inside objects variables and methods and to access them we say object.method