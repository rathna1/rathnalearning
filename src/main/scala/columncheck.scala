
import org.apache.spark.sql.SparkSession

object columncheck {
  def main(args: Array[String]) {

    val spark = SparkSession.builder.master("local[*]")
      .appName("Column Name check in Tables")
        .config("warehouse.dir","/src/main/resources/databases")
      .enableHiveSupport().getOrCreate()
/*
    val listOfTables = Seq(
      "ramu.emp",
      "ramu.dept",
      "ramu.sales",
      "ramu.customer",
      "ramu.product"
    )*/

    import spark.implicits._

    val databasename="customer"

    spark.sql(s"create database if not exists customer")
/*

    val listoftables=spark.catalog.listTables(databasename)


    listoftables.foreach(lt => {
      try {
        val TablesDF = spark.table(lt)
        TablesDF.columns.foreach(c => {
          if (c.toLowerCase() == "item_cd" || c.toLowerCase() == "item_id" || c.toLowerCase() == "item" || c.toLowerCase() == "store" || c.toLowerCase() == "store_id" || c.toLowerCase() == "store_cd" || c.toLowerCase() == "location_id" || c.toLowerCase() == "location" || c.toLowerCase() == "location_cd") {
            println("TableName : " + lt + " ==> " + c)
          }
        })
      } catch {
        case ex: Throwable => println("Table not found in database ==> " + lt)
      }
    })

    */
  }


}
