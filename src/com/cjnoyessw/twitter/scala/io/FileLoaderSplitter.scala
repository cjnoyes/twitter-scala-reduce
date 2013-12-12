package com.cjnoyessw.twitter.scala.io

import java.io.{FileReader,BufferedReader}
import scala.collection.mutable.ArrayBuffer

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 11/29/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
class FileLoaderSplitter(filename : String) {
  private val _rdr : Option[BufferedReader] = Option(new BufferedReader(new BufferedReader(new FileReader(filename))))

  def load : Array[String] = {
    var buffer : ArrayBuffer[String] = new ArrayBuffer[String]()
    if (_rdr == None) { buffer.toArray[String] }
    var str : Option[String] = None
    do {
      str=_rdr.map(_.readLine)
      if (str != None && str != Some(null))
        buffer += str.head
    } while (str != None && str != Some(null))
    buffer.toArray[String]
  }

  def split(ary :Array[String], delim: String="\t") : Array[Array[String]] = {
    val buf : ArrayBuffer[Array[String]] = new ArrayBuffer[Array[String]]()
    for ( i <- 1 until ary.length) { buf+= ary(i).split(delim) }
    buf.toArray[Array[String]]
  }

  def loadAndSplit(delim: String="\t") : Array[Array[String]] = {
      val ary: Array[String] = load
      split(ary,delim)
  }

}
