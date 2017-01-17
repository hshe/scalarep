package org.hshe.impli

/**
  * Created by hshe on 2017/1/17.
  * 隐式转换
  *
  */
class SpecialPerson(val name: String)
class Student(val name: String)
class Older(val name: String)
class Teacher(val name: String)

object Implicit01 {
  implicit def object2SpecialPerson(obj:Object): SpecialPerson = {
    if(obj.getClass == classOf[Student]){
      val stu: Student = obj.asInstanceOf[Student]
      new SpecialPerson(stu.name)
    }else if(obj.getClass == classOf[Older]){
      val older: Older = obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    }else{
      Nil
    }
  }

  var ticketNum = 0

  /**
    * 这里使用了specialPerson这个类，当调用时，就会试图去找返回这个类的隐式转换。
    * 在object 下的implicit定义的方法。
    *
    *
    * @param p
    * @return
    */
  def buySpecialTicket(p:SpecialPerson)={
    ticketNum += 1
    "T-" +ticketNum
  }

  def main(args: Array[String]) {
    val stu: Student = new Student("xaoming")
    println(buySpecialTicket(stu))
    val older: Older = new Older("old")
    println(buySpecialTicket(older))
    val teacher: Teacher = new Teacher("tech")
    println(buySpecialTicket(teacher))
  }
}
