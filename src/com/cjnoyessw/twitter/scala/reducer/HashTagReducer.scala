package com.cjnoyessw.twitter.scala.reducer

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/7/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
class HashTagReducer(col:Int) extends WordFreqReducer(col," ", false) {

  protected override def filter(str : String) : Boolean = str.length() > 1 && str.startsWith("#")

}
