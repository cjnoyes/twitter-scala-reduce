package com.cjnoyessw.twitter.scala

import com.cjnoyessw.twitter.scala.reducer.{ScreenNameReducer}
import com.cjnoyessw.twitter.scala.util.ReduceProcess

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/7/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
object ScreenName extends ReduceProcess("ScreenName.scala") {

  def reduce( col: Int, data: Array[Array[String]] ) : Array[(String,Int)] = {
    val reducer = new ScreenNameReducer(col)
    reducer.reduce(data)
  }

}
