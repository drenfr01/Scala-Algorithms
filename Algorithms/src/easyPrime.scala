object easyPrime {

  def main(args: Array[String]): Unit = {
 
    println(isPrime(14))
  }
  
  def isPrime(n : Int) = List.range(2, n) forall (x => n % x != 0)

}