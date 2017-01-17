package org.hshe.scala

import java.sql.{Connection, DriverManager, PreparedStatement}

/**
  * Created by hshe on 2017/1/17.
  */
object Scala2Mysql {
  def main(args: Array[String]) {
    val jdbc = "jdbc:mysql://192.168.65.12:3306/test?user=root&password=root"
    classOf[com.mysql.jdbc.Driver]
    val conn: Connection = DriverManager.getConnection(jdbc)
    try  {
      val prep: PreparedStatement = conn.prepareStatement("insert into blog (title, body) values(?,?)")
      prep.setString(1,"nothing is greate ")
      prep.setString(2," i am nothing")
      prep.executeUpdate()
    } finally {

    }
  }
}
