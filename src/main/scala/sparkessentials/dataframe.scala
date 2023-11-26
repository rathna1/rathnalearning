package sparkessentials


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.functions._

object dataframe extends Serializable{


  def main(args: Array[String]): Unit = {

    val spark: SparkSession= SparkSession.builder
      .master("local[*]")
      .appName("spark learning")
      .enableHiveSupport().getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")


    val compdf=spark.read.json("/Users/IN99104108/Documents/compusense.json")

    //compdf.printSchema()

    val basisdf=spark.read.csv("/Users/IN99104108/Downloads/UK_GBT_P4_2324_v2.csv")

    basisdf.printSchema()


  }


}
