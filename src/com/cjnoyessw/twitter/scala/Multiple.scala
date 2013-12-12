package com.cjnoyessw.twitter.scala

import com.cjnoyessw.twitter.scala.util.TaskSupport

/**
 * Created with IntelliJ IDEA.
 * User: Christopher J. Noyes
 * Date: 12/8/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
object Multiple {
  def main(args: Array[String]) {
    if (args.length <1) {
      println("Multiple.scala <infile>")
    }
    else {
      try {
        val data = TaskSupport.load(args(0))
        TaskSupport.writeData("source.txt",Source.reduce(2,data))
        TaskSupport.writeData("wordfreq.txt",WordFreq.reduce(3,data))
        TaskSupport.writeData("Hashtag.txt",Hashtag.reduce(3,data))
        TaskSupport.writeData("rtscreenname.txt",ScreenName.reduce(3,data))
        TaskSupport.writeData("UsersTweets.txt",Counter.reduce(9,data),1)
      }
      catch {
        case ex: Exception => {
          println(ex.getMessage())
          ex.printStackTrace()
        }
      }
    }
  }
}
