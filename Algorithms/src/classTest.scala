object classTest {

  def main(args: Array[String]): Unit = {
  
    println(eval(new Sum(new Number(2), new Number(2))))
    
    val x = new EmptyStack[Int]
    val y = x.push(1).push(2)
    println(y.pop.top)
  }
    
  def eval(e : Expr) : Int = e match {
    case Number(n) => n
    case Sum(e1,e2) => eval(e1) + eval(e2)
    
  }
  
  
}