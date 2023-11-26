
import org.apache.spark
import org.apache.spark.sql._
import org.apache.spark.sql.types._

object arraystring extends App {

  val spark: SparkSession = SparkSession.builder()
    .master("local[*]").appName("sparksplit")
    .enableHiveSupport().getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")


  val arrayStructureData = Seq(
    Row("James,,Smith",List("Java","Scala","C++"),List("Spark","Java"),"OH","CA"),
    Row("Michael,Rose,",List("Spark","Java","C++"),List("Spark","Java"),"NY","NJ"),
    Row("Robert,,Williams",List("CSharp","VB"),List("Spark","Python"),"UT","NV")
  )
  val arrayStructureSchema = new StructType()
    .add("name",StringType)
    .add("languagesAtSchool", ArrayType(StringType))
    .add("languagesAtWork", ArrayType(StringType))
    .add("currentState", StringType)
    .add("previousState", StringType)
  val df = spark.createDataFrame(spark.sparkContext.parallelize(arrayStructureData),arrayStructureSchema)
  df.printSchema()
  df.show()

  /*

  df.map(f=>{
    val name=f.getString(0).split(",") //array
    val langschool=f.getList(1).toArray().mkString(",") //string
    val langwork=f.getList(2).toArray().mkString(",") //string
    val a=Array(f.getString(3),f.getString(4)) //array
    (name,langschool,langwork,a) //tuple
  }).toDF("name","languagesAtSchool","languagesAtWork","state").show(false)


   */

}
