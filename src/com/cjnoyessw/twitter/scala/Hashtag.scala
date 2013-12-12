package com.cjnoyessw.twitter.scala

import com.cjnoyessw.twitter.scala.reducer.{HashTagReducer}
import com.cjnoyessw.twitter.scala.util.ReduceProcess

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/7/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
object Hashtag extends ReduceProcess("HashTag.scala") {

  def reduce( col: Int, data: Array[Array[String]] ) : Array[(String,Int)] = {
    val reducer = new HashTagReducer(col)
    reducer.reduce(data)
  }

}
