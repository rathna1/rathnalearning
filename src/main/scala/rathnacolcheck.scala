import org.apache.spark.sql.SparkSession
import java.io.FileWriter
/*
import org.apache.spark

object rathnacolcheck extends App {
  val dbname = "market"


  val tables = spark.catalog.listTables(dbname) //-->dataset
    .select($"name".as("table_name"), $"database".as("database_name"))
  //---->dataframe
  val table_array = tables.collect() //--->array[row]

  table_array.foreach(x => {
    val dbname = x(1).toString
    val tbname = x(0).toString
    println(s"$dbname,$tbname")
  }
  ) //prints all tables in a database
  val dbname = "market"


  table_array.foreach(x => {
    val tbname = x(0).toString
    val dbname = x(1).toString
    val columns = spark.catalog.listColumns(dbname, tbname).select("name").collect
    columns.foreach(x => { //after lambda put curly braces
      val columnname = x(0).toString
      if (columnname.toLowerCase() == "target_week")
        storelist = storelist.:+(dbname + "." + tbname)
    })
    if (storelist.nonEmpty) {
      println(s"$dbname  $tbname")
    }
    storelist.foreach(println)
  })


val OutputFileLocation="/home/id97/size.csv"
val fw=new FileWriter(OutputFileLocation)

table_array.foreach(x => {
  val tbname = x(0).toString
  val dbname = x(1).toString
  var storelist: List[String] = List.empty
  val columns = spark.catalog.listColumns(dbname, tbname).select("name","dataType").collect
  //var i:[Int] = 0
  columns.foreach(x => { //after lambda put curly braces
    val columnname = x(0).toString
    val datatype = x(1).toString
 //   val i=i++
    val final_output=dbname+" "+tbname+" "+columnname+" "+datatype
    println(final_output)
    fw.write(final_output+"\n")

    //println("TableName : " + lt + " ==> " + c)
  }
  )
})
fw.close



uuid 18 length

import org.apache.spark.sql.SparkSession
import java.io.FileWriter

object ColumnNameCheckInTable {

  def ListOfTableNames(spark: SparkSession, listOfDbs: Seq[String], cName: String,OutputFileLocation:String) = {
    val catalog = spark.catalog
    listOfDbs.foreach(dbs => {
      try {
        val listOfTables = catalog.listTables(dbs).select("name")
        listOfTables.collect.foreach(tn => {
          var tName = tn.mkString.replace("[", "").replace("]", "")
          var tables = Seq()
          var tableNames = tables.+:(dbs + "." + tName)
          tableNames.foreach(lt => {
            try {
              val TablesDF = spark.table(lt)
              TablesDF.columns.foreach(c => {
                if (c.toLowerCase() == cName) {
                  val fw=new FileWriter(OutputFileLocation)
                  fw.write(lt+","+c+"\n")
                  fw.close();
                  //println("TableName : " + lt + " ==> " + c)
                }
              })
            } catch {
              case ex: Throwable => println("Table not found in database ==> " + lt)
            }
          })
        })

      } catch {
        case ex: Throwable => println("DataBase Not Found in the Hive ==> " + dbs)
      }
    })
  }

  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("Column Name check in Tables").enableHiveSupport().getOrCreate()

    import spark.implicits._

    val columnName = "item"
    val dbs = "orders,gap"
    val OutputFileLocation="/home/ramu/TablesList.csv"

    /*val columnName = args(1)
    var dbs=args(2)
    val OutputFileLocation=args(3)*/

    val Databases: Seq[String] =dbs.split(",").toSeq
    val listOfDbs = Databases

    ListOfTableNames(spark, listOfDbs, columnName,OutputFileLocation)


2. dbname,tablename1
dbname,tablename2

-------------------------

2. dbname,[tablename]

3. [dbname,tablename1]
   [dbaname,tablename2]

1. dbname,tablename,[all cols]


2. [dbname,tablename,col1]
  [dbname,tablename,col2]

-----------------------------------

spark.catalog.listColumns("customer","walnut_store")


3. dbname,tablename,col1
   dbname,tablename,col2


*/


