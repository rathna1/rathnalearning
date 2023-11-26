package sparkessentials

import org.apache.spark.sql._
import org.apache.spark.sql.types._


object datasources extends App{

  val spark: SparkSession = SparkSession.builder()
    .appName("Data sources")
    .config("spark.master","local")
    .enableHiveSupport().getOrCreate()


  val carsSchema = StructType(Array(
    StructField("Name", StringType),
    StructField("Miles_per_Gallon", DoubleType),
    StructField("Cylinders", LongType),
    StructField("Displacement", DoubleType),
    StructField("Horsepower", LongType),
    StructField("Weight_in_lbs", LongType),
    StructField("Acceleration", DoubleType),
    StructField("Year", DateType),
    StructField("Origin", StringType)
  ))

  val carsDF = spark.read
    .format("json")
    .schema(carsSchema) // enforce a schema
    .option("mode", "failFast") // dropMalformed, permissive (default)
    .option("path", "src/main/resources/data/cars.json")
    .load()


  val carsDFwithOptions = spark.read
    .format("json")
    .options(Map(
      "inferschema" -> "true",
      "mode" -> "failFast",
      "path" -> "src/main/resources/data/cars.json"
    ))
    .load()

  carsDF.write
    .format("json")
    .mode(SaveMode.Overwrite)
    .save("src/main/resources/data/cars_dup.json")

  spark.read
    .schema(carsSchema)
    .option("dateFormat", "YYYY-MM-dd") // couple with schema; if Spark fails parsing, it will put null
    .option("allowSingleQuotes", "true")
    .option("compression", "uncompressed") // bzip2, gzip, lz4, snappy, deflate
    .json("src/main/resources/data/cars.json")


  val stocksschema = StructType(Array(
    StructField("symbol",StringType),
    StructField("date",DateType),
    StructField("price",DoubleType),



  ))

  spark.read
    .schema("stocksschema")
    .format("csv")
    .option("header","true")
    .option("delimiter",",")

  val StockDF = spark.read
      .schema("stocksschema")
    .format("csv")
    .options(Map(
      "header" -> "true",
      "delimiter" -> ","
     ))
    .load("/src/main/resources/data/stocks.csv")

  spark.read
    .format("jdbc")
    .option("driver","org.postgresql.driver")
    .option("url","jdbc:postgresql://localhost:5432/rtjvm")
    .option("user","docker")
    .option("password","docker")
    .option("dbtable","public.employees")
    .load()

}
