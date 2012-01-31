package sortingAlgorithms

object MergeSort {

  val SENTINAL = 1000000000;

  def main(args: Array[String]): Unit = {
    val list = Array(15, 12)
    println(mergeSort(list, 0, (list.length - 1)))
  }

  def mergeSort(A: Array[Int], p: Int, r: Int): Array[Int] =
    {
      if (p < r) {
        var q = Math.floor((p + r) / 2).toInt
        mergeSort(A, p, q)
        mergeSort(A, q + 1, r)
        merge(A, p, q, r)
      }

      return A

    }

  def merge(A: Array[Int], p: Int, q: Int, r: Int): Array[Int] = {
    
    println(A.toList, p,q,r)
    var lengthLeftSubArray = q - p + 1
    var lengthRightSubArray = r - q
    //copy over elements from sub-array A to new subArrays
    val leftArray = new Array[Int](lengthLeftSubArray + 1)
    val rightArray = new Array[Int](lengthRightSubArray+ 1)
    A.copyToArray(leftArray, p, lengthLeftSubArray)
    A.copyToArray(rightArray, q, lengthRightSubArray)

    //insert sentinel
    leftArray(lengthLeftSubArray) = SENTINAL
    rightArray(lengthRightSubArray) = SENTINAL

    println(leftArray.toList, rightArray.toList)
    //execute merge, done in "two-pointer" comparison manner
    var i = 0
    var j = 0

    for (k <- p to r) {
      if (leftArray(i) <= rightArray(j)) {
        A(k) = leftArray(i)
        i = i + 1
      } else {
        A(k) = rightArray(j)
        j = j + 1
      }

    }

    return A

  }
}