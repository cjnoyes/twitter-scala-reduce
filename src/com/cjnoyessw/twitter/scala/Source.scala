package com.cjnoyessw.twitter.scala

import com.cjnoyessw.twitter.scala.reducer.{TransformingReducer}
import com.cjnoyessw.twitter.scala.util.ReduceProcess

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/8/13
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */
object Source extends ReduceProcess("Source.scala") {

  def transform(str:String) : String = {
     if (!str.startsWith("<a")) { str } else {
        val pos = str.indexOf(">")
        val endPos = str.indexOf("<",pos+1)
        str.substring(pos+1,endPos)
     }
  }

  def reduce( col: Int, data: Array[Array[String]] ) : Array[(String,Int)] = {
    val reducer = new TransformingReducer(col,transform)
    reducer.reduce(data)
  }

}
