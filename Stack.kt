package com.mu.jan.dsandalgo

fun main(){
    val stack = Stack<Int>()

    //Stack using LinkedList (Node)
    stack.push(1).push(2).push(3).pop()

    println("$stack")

}
//Stack using LinkedList
class Stack<T>{
    private var top : Node<T>? = null
    private var size: Int = 0

    fun push(value: T): Stack<T>{
        val newNode = Node(value = value)
        if(top==null){
            top = newNode
        }else{
            val oldTop = top
            top = newNode
            newNode.next = oldTop
        }
        size++
        return this
    }
    fun pop(): Stack<T>{
        if(top!=null){
            top = top?.next
            size--
        }
        return this
    }
    //peek() it returns value at top
    fun peek(): T?{
        return if(top==null) null
        else top?.value
    }

    override fun toString(): String {
        return if(top==null) "Empty"
        else top.toString()
    }
}

