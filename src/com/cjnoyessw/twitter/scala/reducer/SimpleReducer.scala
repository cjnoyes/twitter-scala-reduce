package com.cjnoyessw.twitter.scala.reducer

import scala.collection.mutable.{ArrayBuffer}


/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 11/29/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */

class SimpleReducer(col : Int) {

   protected def select(ary :Array[Array[String]]) : Array[String] = {
      var buf : ArrayBuffer[String] = new ArrayBuffer[String]()
      if (ary.length ==0) { buf.toArray[String] }
      var ent : Array[String] = ary(0)
      if (ent.length-1 < col) { buf.toArray[String] }
      for ( i <- 1 until ary.length)  { ent = ary(i); buf+= ent(col)}
      buf = buf.sortWith(_<_)
      buf.toArray[String]
   }

   protected def reduce(ary: Array[String]) : Array[(String,Int)] = {
      var buf : ArrayBuffer[(String,Int)] = new ArrayBuffer[(String,Int)]()
      var count:Int = 0
      var curr = ""
      for ( i <- 1 until ary.length ) {
          if (curr == "" ) {
              curr = ary(i)
              count = 1
             }
          else if (ary(i) != curr) {
             buf+=((curr,count))
             count = 1
             curr = ary(i)
          }
          else count = count+1
      }

      buf.+=((curr,count))
      buf = buf.sortWith(_._2 > _._2)
      buf.toArray[(String,Int)]
   }

  def reduce(ary :Array[Array[String]]) : Array[(String,Int)] = {
      var sel: Array[String] = select(ary)
      reduce(sel)
   }




}
