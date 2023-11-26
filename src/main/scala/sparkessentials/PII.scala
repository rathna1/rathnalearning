package sparkessentials

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._


object PII extends App{


  val spark: SparkSession= SparkSession.builder
    .master("local[*]")
    .appName("spark learning")
    .enableHiveSupport().getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val PIIdata=Seq((124,"john's email is john@example.com, and his phone number is 123-456-7890."),
    (124,"Mary Smith lives at 123 Main St, Apt 4B, New York, NY 10001."),
    (125,"abcd@gmail.com has this phone number 123-1234-234"))

  import spark.implicits._

  val PIIdataDf=PIIdata.toDF("employeeid","comments")

  PIIdataDf.printSchema()

  val emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
  val phonePattern = "\\d{3,}+[-]\\d{3,}+[-]+\\d{3,}"

  val PIIdatareplaced=
    PIIdataDf.withColumn("comment_new", regexp_replace(col("comments"),s"${emailPattern}|${phonePattern}","[REPLACED]"))
        .select("employeeid","comment_new")

  PIIdatareplaced.show(false)


}
