package sparkessentials

import spacy
from pyspark.sql.functions import udf
from pyspark.sql.types import StringType


object spacy extends App{

  from pyspark.sql import SparkSession

  spark = SparkSession.builder \
  .appName("PIIDetection") \
  .getOrCreate()

}
