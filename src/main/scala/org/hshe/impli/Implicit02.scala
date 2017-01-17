package org.hshe.impli

/**
  * Created by hshe on 2017/1/17.
  * 使用隐式转换，加强现有类型。
  * （装饰类型。）
  * 类型没有方法时，会尝试隐式转换。
  *
  */
class Man(val name:String)
class Superman(val name:String){
  def bianshen = println("true Man ！")
}

object Implict02 {
  implicit def man2Superman(man:Man):Superman = new Superman(man.name)

  def main(args: Array[String]) {
    val hshe: Man = new Man("hshe")

    /**
      * 调用这个方法时，类中没有这个方法，就会试图去做隐式转换。
      */
    hshe.bianshen
  }
}
