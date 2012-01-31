package random

object FirstClassFunctions {
  
  def main (args : Array[String]) : Unit = {
    
    println(sumInts(1, 10))
    
    println(sumSquares(1,4))
    
    println(sumPowerOfTwo(1,3))
    
    //anonymous sumInts
    
    println(sum((x: Int) => x, 1, 10))
    
    //anonymous sumSquares
    println(sum((x: Int) => x * x, 1, 4))
    
    //curried sumInts
    println(cSumInts(1, 10))
    
    //curried sumSquares
    
    println(cSumSquares(1,4))
    
    var fun = currySum( (x: Int) => x)_
    
    
    
  }
  
  def sumInts(a: Int, b:Int) : Int = {
    if (a > b) 0 else a + sumInts(a +1, b)
  }

  def sumSquares(a: Int, b: Int) : Int= {
    def square(x: Int) : Int = x * x
    
    if(a > b) 0 else square(a) + sumSquares(a+1,b)
   }
  
  def sumPowerOfTwo(a: Int, b: Int) : Int = {
    def powerOfTwo(x: Int) : Int = if(x == 0) 1 else 2 * powerOfTwo(x-1) 
    
    if (a>b) 0 else powerOfTwo(a) + sumPowerOfTwo(a + 1, b)
  }
  
  //general pattern
  def sum(f: Int => Int, a: Int, b: Int) : Int = 
	if(a > b)  0 else f(a) + sum(f, a+1,b)
	
  //currying like a boss
  def cSum(f: Int => Int) : (Int, Int) => Int = {
    def sumF(a: Int, b: Int) : Int = 
      if (a > b) 0 else f(a) + sumF(a+1, b)
     sumF
  }
  
  //curried sumInts
  def cSumInts = cSum(x => x)
  
  def cSumSquares = cSum(x=> x * x)
  
  //even better currying, can specify variables will be passed in future 
  def currySum(f: Int => Int)(a: Int, b: Int) : Int = 
    if(a > b) 0 else f(a) + currySum(f)(a+1, b)
  
}