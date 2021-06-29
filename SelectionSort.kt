package com.mu.jan.dsandalgo

fun main() {
    SelectionSort().sortByAsc(arrayOf(10,9,8,7,6,5,4,3,2,1))
}
class SelectionSort{
    fun sortByAsc(a: Array<Int>){
        for(i in 0 until a.size-1){
            var swap = false
            for(j in 0 until a.size-1-i){
                if(a[j]>a[j+1]){
                    val temp = a[j]
                    a[j] = a[j+1]
                    a[j+1] = temp
                    swap = true
                }
            }
            if(!swap) break
        }
        for (i in a.indices){
            print("${a[i]}  ")
        }
    }
}