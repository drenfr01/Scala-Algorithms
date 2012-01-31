package sortingAlgorithms

object QuickSort {
	
	def main(args : Array[String]) : Unit = {
		
	  var list = Array(2,8,7,1,3,5,6,4)
	  println(sort(Array(1,7,3,2,8,17,5)).toList)

	}
  
  //Infinitely better quick sort
  def sort(xs : Array[Int]) : Array[Int] = {
	  if(xs.size <= 1) xs
	  else {
	    val pivot = xs(xs.length / 2)
	    Array.concat(sort (xs filter (pivot >)), 
	    			 xs filter (pivot ==),
	    			 sort (xs filter (pivot <))
	    			 )    			 
	  }
 	}
	def quickSort(list : Array[Int], p : Int, r: Int) : Array[Int] = {
	  
	  if(p < r)
	  {
	    var q = partition(list, p, r)
	    quickSort(list, p, q-1)
	    quickSort(list, q+1, r)
	  }
	  
	  return list
	}
	
	def partition(list : Array[Int], p : Int, r: Int) : Int = {
	  var x = list(r)
	  var i = p - 1
	  
	  for(j <- p to (r - 1)) {
	    if(list(j) <= x)
	    {
	      i = i + 1
	      var temp = list(i)
	      list(i) = list(j)
	      list(j) = temp
	    }
	  }
	   var temp = list(i+1)
	   list(i+1) = list(r)
	   list(r) = temp
	   
	   return i + 1
	}
	
}