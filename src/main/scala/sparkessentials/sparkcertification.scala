package sparkessentials

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import java.sql.Date._

import org.apache.spark.sql.types._
import sparkessentials.Dataframebasics.spark
object sparkcertification extends App{

  val spark: SparkSession= SparkSession.builder
    .master("local[*]")
    .appName("spark learning")
    .enableHiveSupport().getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")
/*

 val  users = Seq(
   {
    "id": 1,
    "first_name": "Corrie",
    "last_name": "Van den Oord",
    "email": "cvandenoord0@etsy.com",
    "phone_numbers": Row(mobile="+1 234 567 8901", home="+1 234 567 8911"),
    "courses": [1, 2],
    "is_customer": True,
    "amount_paid": 1000.55,
    "customer_from": datetime.date(2021, 1, 15),
    "last_updated_ts": datetime.datetime(2021, 2, 10, 1, 15, 0)
},
  {
    "id": 2,
    "first_name": "Nikolaus",
    "last_name": "Brewitt",
    "email": "nbrewitt1@dailymail.co.uk",
    "phone_numbers":  Row(mobile="+1 234 567 8923", home="1 234 567 8934"),
    "courses": [3],
    "is_customer": True,
    "amount_paid": 900.0,
    "customer_from": datetime.date(2021, 2, 14),
    "last_updated_ts": datetime.datetime(2021, 2, 18, 3, 33, 0)
  },
  {
    "id": 3,
    "first_name": "Orelie",
    "last_name": "Penney",
    "email": "openney2@vistaprint.com",
    "phone_numbers": Row(mobile="+1 714 512 9752", home="+1 714 512 6601"),
    "courses": [2, 4],
    "is_customer": True,
    "amount_paid": 850.55,
    "customer_from": datetime.date(2021, 1, 21),
    "last_updated_ts": datetime.datetime(2021, 3, 15, 15, 16, 55)
  }

    {
        "id": 4,
        "first_name": "Ashby",
        "last_name": "Maddocks",
        "email": "amaddocks3@home.pl",
        "phone_numbers": Row(mobile=None, home=None),
        "courses": [],
        "is_customer": False,
        "amount_paid": None,
        "customer_from": None,
        "last_updated_ts": datetime.datetime(2021, 4, 10, 17, 45, 30)
    },
    {
        "id": 5,
        "first_name": "Kurt",
        "last_name": "Rome",
        "email": "krome4@shutterfly.com",
        "phone_numbers": Row(mobile="+1 817 934 7142", home=None),
        "courses": [],
        "is_customer": False,
        "amount_paid": None,
        "customer_from": None,
        "last_updated_ts": datetime.datetime(2021, 4, 2, 0, 55, 18)
 )

*/


  val usersold = Seq(Row(1,"Corrie","Van den Oord","cvandenoord0@etsy.com",List("+1 234 567 8901", "+1 234 567 8911"),List(1, 2),true,1000.55,current_date,current_timestamp()),
    Row((2,"Nikolaus","Brewitt","nbrewitt1@dailymail.co.uk",List("+1 234 567 8923", "1 234 567 8934"),List(3),true,900.0,current_date(),current_timestamp())),
    Row((3,"Orelie","Penney","openney2@vistaprint.com",List("+1 714 512 9752", "+1 714 512 6601"),List(2,4),true,850.55,current_date(),current_timestamp())),
    Row((4,"Ashby","Maddocks","amaddocks3@home.pl",List(),List(),false,null,current_date(),current_timestamp())),
    Row((5,"Kurt","Rome","krome4@shutterfly.com",List("+1 817 934 7142",""),List(),false,null,current_date(),current_timestamp()))
  )

  val usersoldschema = StructType(Array(
    StructField("id",IntegerType),
    StructField("first_name",StringType),
    StructField("last_name",StringType),
    StructField("email",StringType),
    StructField("phone_numbers",ArrayType(StringType)),
    StructField("courses",ArrayType(IntegerType)),
    StructField("is_customer",BooleanType),
    StructField("amount_paid",DoubleType),
    StructField("customer_from",DateType),
    StructField("last_updated_ts",TimestampType)
  ))


  val usersoldrdd= spark.sparkContext.parallelize(usersold)

  usersoldrdd.foreach(println)

  //val usersolddf=spark.createDataFrame(spark.sparkContext.parallelize(usersold),usersoldschema)



  println(usersold)



}
