package com.cjnoyessw.twitter.scala.reducer

import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.HashMap

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 11/29/13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
class WordFreqReducer(col : Int, regex : String = "\\W", lowercase:Boolean=true, minLen: Int=3) extends SimpleReducer(col) {

   protected def filter(str : String) : Boolean = str.length() > minLen

   protected override def select(ary :Array[Array[String]]) : Array[String] = {
       var data =super.select(ary)
       var buf : ArrayBuffer[String] = new ArrayBuffer[String]()
       var ent : Array[String] = ary(0)
       if (ent.length-1 < col) { buf.toArray[String] }
       for ( i <- 1 until ary.length)  { ent = ary(i)
         var str=ent(col);
         if (lowercase) {str = str.toLowerCase}
         var words: Array[String] = str.split(regex)
         words.foreach(word => {if (filter(word)) buf+=word})
       }
       buf = buf.sortWith(_<_)
       buf.toArray[String]
   }

}
