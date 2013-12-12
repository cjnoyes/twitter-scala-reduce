package com.cjnoyessw.twitter.scala.reducer

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/7/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
class ScreenNameReducer(col:Int) extends WordFreqReducer(col," ", false) {

  protected override def filter(str : String) : Boolean = str.length() > 2 && str.startsWith("@")

}
