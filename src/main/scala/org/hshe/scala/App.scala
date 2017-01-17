package org.hshe.scala

/**
 * Hello world!
 *
 */
object App extends Application {
  println( "Hello World!" )


//
  lazy val lazyVal = { println(" i'm lazy !");1}

  val nonLazyVal = { println(" none lazy! ");2;}

  //lazy value init
  lazyVal

  //函数柯里化。把参数一个个独立开来。下面是demo
  def multiply(x:Int)(y:Int) = x*y
  println(multiply(1)(3))
  def m2 = multiply(2)_
  println(m2(3))

  //匿名函数。更多情况下，是作为一个参数让其它对象调用的。
  val t = ()=>333//声明了一个函数对象付给了t
  println(t())//有有括号。
  def testfun0(c: ()=>Int): Unit = {
    println(c())
    1000
  }
  testfun0(t)//匿名函数传进去。
  val t2 = (a:Int)=> a+100
   //匿名函数作为参数，后面跟上参数类型、表达式。
  def testfun2(callback: (Int,Int)=>Int)={
     println(callback(123,321))
   }

//  嵌套函数，其实就是def里面再定义def
  def add3(x:Int, y:Int, z:Int) : Int = {
    def add2(x:Int, y:Int):Int = {
      x + y
    }
  add2(add2(x,y),z)
  }
  println(add3(1,2,3))



}
