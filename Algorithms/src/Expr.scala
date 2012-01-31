abstract class Expr 

case class Number(n: Int) extends Expr 

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr 