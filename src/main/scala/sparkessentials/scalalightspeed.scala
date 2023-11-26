package sparkessentials

object scalalightspeed extends App {



  val meaningOfLife = 42

  val ifExpression = if (meaningOfLife > 43) 56 else 999 // in other languages: meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0


}
