/*
object tabledatatypes {



  val tablelist=List("ngc_uk_clubcard")



val df = spark.table("customer.ngc_uk_clubcard").select("CustomerId",
  "InsertDatetime",
  "clubcardid",
  "hashed_clubcardid",
  "Clubcardtype",
  "Clubcardtypedescenglish",
  "Cardissueddate",
  "Amenddatetime")

  df.dtypes.foreach(f=>println(f._2))
}
*/





