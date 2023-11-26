package sparkessentials

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.{ Window}
import org.apache.spark.sql.functions._




object Dataframebasics extends App{

   val spark: SparkSession= SparkSession.builder
     .master("local[*]")
     .appName("spark learning")
     .enableHiveSupport().getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

  val data=Seq(("abc","xyz@outlook.com"),
    ("bcd","pqr@gmail.com"),
    ("efg","lmn@yahoo.com"),
    ("edf","poc@apple.com")
  )

  val PIIdata=Seq((124,"John Doe's email is john@example.com, and his phone number is 123-456-7890."),
     (124,"Mary Smith lives at 123 Main St, Apt 4B, New York, NY 10001."),
     (125,"Patient: John Doe, SSN: 123-45-6789, DOB: 01/15/1980, Address: 456 Elm St."))



  import spark.implicits._

  val data1=Seq((1, Array(30, 5, 20, 10)),(2,Array(20, 10)))

  val data1Schema=data1.toDF("BOOKID","no_of_books")

  data1Schema.printSchema()

  val data1final=data1Schema
  //println(data1final)



  val df=data.toDF("name","email")

  val df1=df.withColumn("id",row_number() over(Window.partitionBy().orderBy(col("email"))))
    .withColumn("domain1",split(col("email"),"@")(1))
    .withColumn("domain",split(col("domain1"),"\\.")(0)).drop("domain1")
    .show(false)

  val phonedata=Seq(
    ("nokia","japan","100pixels"),
      ("motorolla","korea","200pixels"),
    ("redmi","china","50pixels")
  )

  val phonedatadf=phonedata.toDF("PHONE_NAME","PHONE_MAKE_CTRY","CAMERA_PIXELS")

  phonedatadf.show(200)


  val listvalues=List(1,2,3,4,5)

  println(listvalues:+ 42)

    val numbers= List(1,2,3,4,5,6)

  import spark.implicits._

  val numbersDF1 = numbers.toDF("num1")

  println(numbersDF1.filter(col("num1") > 6))



  val a = List(10, 11, 17, 89, 17, 34, 5, 78, 65)
  var max = 0

  a.foreach( { a => if (a > max ) max=a})

  println(max)




  val suma = a.reduce(_+_)
  println(suma)


      var sumaa = 0
  a.foreach ( i =>{
    sumaa = sumaa + i
  })

  println(sumaa)


  var sumb=0
   for (i <- a) {
    sumb = sumb+ i

   }
  println(sumb)






}
