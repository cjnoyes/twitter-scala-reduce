package com.cjnoyessw.twitter.scala

import com.cjnoyessw.twitter.scala.reducer.{WordFreqReducer}
import com.cjnoyessw.twitter.scala.util.ReduceProcess

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 11/29/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */

object WordFreq extends ReduceProcess("WordFreq.scala") {

  def reduce( col: Int, data: Array[Array[String]] ) : Array[(String,Int)] = {
    val reducer = new WordFreqReducer(col)
    reducer.reduce(data)
  }

}
