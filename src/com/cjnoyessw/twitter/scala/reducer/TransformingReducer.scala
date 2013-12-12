package com.cjnoyessw.twitter.scala.reducer

import scala.collection.mutable.ArrayBuffer

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/8/13
 * Time: 8:42 AM
 * To change this template use File | Settings | File Templates.
 */
class TransformingReducer(col : Int, transform : String=>String ) extends SimpleReducer(col) {

  protected override def select(ary :Array[Array[String]]) : Array[String] = {
    var buf : ArrayBuffer[String] = new ArrayBuffer[String]()
    if (ary.length ==0) { buf.toArray[String] }
    var ent : Array[String] = ary(0)
    if (ent.length-1 < col) { buf.toArray[String] }
    for ( i <- 1 until ary.length)  { ent = ary(i); buf+= transform(ent(col))}
    buf = buf.sortWith(_<_)
    buf.toArray[String]
  }

}
