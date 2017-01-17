package org.hshe.impli

/**
  * Created by hshe on 2017/1/17.
  * 类型方法有，但参数不一致，会尝试调用隐式转换。
  */
class TicketHouse {
  var ticketNum = 0
  def buySpecialTicket(specialPerson: SpecialPerson) = {
    ticketNum += 1
    "T-" + ticketNum
  }
}
object Implicit03 {
  implicit def object2SpecialPerson(obj:Object): SpecialPerson = {
    if(obj.getClass == classOf[Student]){
      val stu: Student = obj.asInstanceOf[Student]
      new SpecialPerson(stu.name)
    }else if(obj.getClass == classOf[Older]){
      val older: Older = obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    }else {
      Nil
    }
  }

  def main(args: Array[String]) {
    val house: TicketHouse = new TicketHouse
    val stu: Student = new Student("stu")
    val teacher: Teacher = new Teacher("hshe")

    /**
      * 去买票时，接收的参数是SpecialPerson
      * 就试图去隐式转换，只有学生转成功，老师不成功，不可以买票。
      */
    println(house.buySpecialTicket(stu))
    println(house.buySpecialTicket(teacher))
  }
}
