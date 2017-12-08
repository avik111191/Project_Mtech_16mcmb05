package nsga2

import org.apache.spark.SparkContext 
import org.apache.spark.SparkContext._ 
import org.apache.spark._  
 


object app {
  

  def main(args: Array[String]) {
        val transactionsIn = args(1)
        val usersIn = args(0)
        val conf = new SparkConf().setAppName("SparkJoins").setMaster("local")
        val conext = new SparkContext(conf)
        val job = new ExampleJob(context)
        val results = job.run(transactionsIn, usersIn)
        val output = args(2)
        results.saveAsTextFile(output)
        context.stop()
  }

}