package org.hshe.actors

import scala.actors.Actor

/**
  * Created by hshe on 2017/1/17.
  */
class HelloActor extends Actor{
  def act(){
    while (true){
      receive{
        case name:String => println("Hello, " + name)
        case money:Int => println("How much? " + money)
      }
    }
  }
}

object HelloActor {
  def main(args: Array[String]) {
    val helloActor = new HelloActor
    helloActor.start()
    helloActor ! 100
  }
}