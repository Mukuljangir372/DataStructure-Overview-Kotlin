package com.mu.jan.dsandalgo

fun main() {
    BubbleSort().sortByAsc(arrayOf(10,9,8,7,6,5))
}
class BubbleSort {
    fun sortByAsc(a: Array<Int>){
        var swap = true
        while(swap){
            swap = false
            for(i in 0 until a.size-1){
                if(a[i]>a[i+1]){
                    val temp = a[i]
                    a[i] = a[i+1]
                    a[i+1] = temp

                    swap = true
                }
            }
        }
        for(i in a.indices){
            print("${a[i]} ")
        }
    }
}