object generalMergeSort {

  def main(args: Array[String]): Unit = {
    println(mergeSort((x : Int, y: Int) => x < y)(List(7,4,15,6)))
    
    //curried, so can make special version of mergeSort
    val intSort = mergeSort((x: Int, y: Int) => x < y)_
    val reverseSort = mergeSort((x:Int, y: Int) => x > y)_
    
    println("Partially applied Integer Merge Sort " + intSort(List(7,4,15,6)))
    println("Partially applied Reverse Merge Sort " + reverseSort(List(7,4,15,6)))
  }

  def mergeSort[A](lessThan: (A, A) => Boolean)(xs: List[A]): List[A] = {
    def merge(l1: List[A], l2: List[A]): List[A] = {

      if (l1.isEmpty) l2
      else if (l2.isEmpty) l1
      else if (lessThan(l1.head, l2.head)) l1.head :: merge(l1.tail, l2)
      else l2.head :: merge(l1, l2.tail)
    }
    val n = xs.length / 2
    if (n == 0) xs
    else merge(mergeSort(lessThan)(xs take n), mergeSort(lessThan)(xs drop n))
  }
}