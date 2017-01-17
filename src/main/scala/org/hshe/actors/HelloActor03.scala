package org.hshe.actors

import scala.actors.Actor

/**
  * Created by hshe on 2017/1/17.
  */
case class Message(content:String, sender:Actor)

class Server extends Actor{
  override def act(): Unit = {
    while (true){
      receive{
        case Message(content, sender) => {println("receive:"+content); sender ! "i receive  bye!"}
      }
    }
  }
}

class Client(val server: Server) extends Actor{
  override def act(): Unit = {
    server ! Message("hello ,server, i'm client....",this)

    while (true){
      receive{
        case response:String => println("return from server:"+response)
      }
    }
  }
}
object Message{
  def main(args: Array[String]) {
    val server: Server = new Server
    val client: Client = new Client(server)
    server.start()
    client.start()
  }
}