package com.cjnoyessw.twitter.scala.io

import java.io.{PrintWriter, FileWriter}
import scala.collection.immutable.HashMap
/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 11/29/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
class DataWriter(filename: String, sep : String = "\t") {
   private val _rtr : PrintWriter = new PrintWriter(new FileWriter(filename))

   def heading(col1: String, col2: String) = {
      _rtr.append(col1).append(sep).println(col2)
      this
   }

   def write(key : String, value : Int) = {
      _rtr.append(key).append(sep).println(value)
      this
   }

   def writeAll(ary: Array[(String,Int)]) = {
       ary.foreach(e=>{write(e._1,e._2)})
       this
   }

   def close : Unit = { _rtr.flush(); _rtr.close() }
}
