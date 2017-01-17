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


}
