package org.hshe.impli

/**
  * Created by hshe on 2017/1/17.
  * 隐式参数（有点难理解）
  */
class SignPen{
  def write(content: String) = println(content)
}
object ImplicitContent{
  implicit val signPen = new SignPen
}
object Implicit04 {
  /**
    * 克里化写法。
    * @param name
    * @param signPen
    * 参数定义在其它类型里面。
    */
  def signForExam(name:String)(implicit signPen: SignPen):Unit = {
    signPen.write(name +" arrive in time")
  }

  def main(args: Array[String]) {
    //使用时，导入
    import ImplicitContent._
    /**
      * 把参数隐藏掉，其实是抽到隐式转换中去了。
      * 在调用这个方法产引入，在声明处声明了隐式。
      */
    signForExam("hello")
    signForExam("world")
  }
}
