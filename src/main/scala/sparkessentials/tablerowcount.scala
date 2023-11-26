/*

package sparkessentials

object tablerowcount extends App{

  spark.sql(s"describe formatted  ${tablename}").filter("col_name='Database' or col_name='Table' or col_name='Type' or col_name='Owner' or col_name='Location' or col_name='Statistics'")
    .select("col_name","data_type").groupBy().pivot("col_name").agg(first("data_type"))

}
*/