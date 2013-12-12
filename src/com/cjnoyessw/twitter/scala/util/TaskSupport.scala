package com.cjnoyessw.twitter.scala.util

import com.cjnoyessw.twitter.scala.io.{FileLoaderSplitter, DataWriter}

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/7/13
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
object TaskSupport {

  def load(name:String) = {
    val loader = new FileLoaderSplitter(name)
    loader.loadAndSplit()
  }

  def writeData(name:String, data:Array[(String,Int)], min : Int = 10, label:String="Value", countLabel:String="Count") = {
    val writer = new DataWriter(name)
    writer.heading(label,countLabel)
    val ary = data.filter(_._2 > min)
    writer.writeAll(ary)
    writer.close
  }


}
