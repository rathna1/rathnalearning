import org.apache.spark.sql.SparkSession

object columncheck {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().
      appName("Column Name check in Tables").
      enableHiveSupport().getOrCreate()
/*
    val listOfTables = Seq(
      "ramu.emp",
      "ramu.dept",
      "ramu.sales",
      "ramu.customer",
      "ramu.product"
    )*/

    val listofdbs=spark.
    val listoftables=spark.catalog.listTables(databasename)

    listOfTables.foreach(lt => {
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
  }
}
