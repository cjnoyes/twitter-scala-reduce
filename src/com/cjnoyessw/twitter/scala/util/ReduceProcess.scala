package com.cjnoyessw.twitter.scala.util


/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/7/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class ReduceProcess(name: String) {

  def reduce( col: Int, data: Array[Array[String]] ) : Array[(String,Int)]

  def main(args: Array[String]) {
    if (args.length <3) {
      println(name + " <infile> <col> <outfile>")
    }
    else {
      try {
        val data = TaskSupport.load(args(0))
        TaskSupport.writeData(args(2),reduce(args(1).toInt,data))
      }
      catch {
        case ex: Exception => {
          println(ex.getMessage())
          ex.printStackTrace()
        }
      }
    }
  }

}
