package com.mu.jan.dsandalgo

fun main() {
    var a = arrayOf(1,2,3,4,5,6,7,8,9)
    print("${BinarySearchImpl().binarySearch(a,8)}")
}
class BinarySearchImpl {
    //findOut the element from sorted array
    fun binarySearch(a: Array<Int>,element: Int): Int?{
        var low = 0 //low index
        var high = a.size - 1 //high index

        while(low<=high){
            //middle index
            val mid = (high + low)/2

            if(a[mid]==element) return mid

            else if(element > a[mid]){
                low = mid + 1
            }else {
                high = mid - 1
            }
        }
        return null
    }
}