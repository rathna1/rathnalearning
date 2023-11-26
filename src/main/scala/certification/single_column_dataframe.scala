package certification

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType

object single_column_dataframe extends App {


  val spark: SparkSession= SparkSession.builder
    .master("local[*]")
    .appName("spark learning")
    .enableHiveSupport().getOrCreate()


//List of values , create a singlecolumn dataframe
  val ages=List(21,23,18,41,32)





}
