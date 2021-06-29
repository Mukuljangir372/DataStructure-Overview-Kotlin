package com.mu.jan.dsandalgo

fun main(){
    val queue = ArrayListQueue<Int>()
    queue.enqueue(1).enqueue(2).enqueue(3)
    queue.dequeue()
    println(queue)
}
interface Queue<T>{
    fun enqueue(element: T): ArrayListQueue<T>
    fun dequeue() : ArrayListQueue<T>
    fun peek() : T?
    fun isEmpty() : Boolean
}
class ArrayListQueue<T>() : Queue<T>{
    private val list = arrayListOf<T>()
    override fun enqueue(element: T): ArrayListQueue<T> {
        list.add(element)
        return this
    }
    override fun dequeue() : ArrayListQueue<T>{
        if(!isEmpty()) list.removeAt(0)
        return this
    }
    override fun peek(): T? {
        return if(!isEmpty()) list[list.size-1]
        else null
    }
    override fun isEmpty(): Boolean {
        return if(list.size<=0) return true
        else false
    }

    override fun toString(): String {
        return if(isEmpty()) "Empty"
        else "Bottom : ${list[0]} Top: ${list[list.size-1]}"
    }
}