object functionalQuickSort {
	
  def main(args: Array[String]) = {
    sort(Array(1,7,3,2,8,17,5))
  }
  
  
  def sort(xs : Array[Int]) : Array[Int] = {
	  if(xs.size <= 1) xs
	  else {
	    val pivot = xs(xs.length / 2)
	    Array.concat(sort (xs filter (pivot <)), 
	    			 xs filter (pivot ==),
	    			 sort (xs filter (pivot >))
	    			 )    			 
	  }
 	}
  
}