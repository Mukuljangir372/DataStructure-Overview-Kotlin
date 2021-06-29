package com.mu.jan.dsandalgo

fun main(){
    var list = LinkedList<Int>()
    for(i in list){

    }
    println(list)
}
class LinkedList<T>: MutableIterable<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean{
        return size == 0
    }
    override fun toString(): String {
        return if(isEmpty()){
            "Empty list"
        }else {
            head.toString()
        }
    }

    //push : Adds a value at the front of the list
    fun push(value: T): LinkedList<T>{
        head = Node(value = value,next = head)
        if(tail==null) tail = head
        size++
        return this
    }
    //append : Adds a value at the end of this list
    fun append(value: T): LinkedList<T>{
        if(isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this
    }
    //retrieve node based on given index
    fun nodeAt(index: Int): Node<T>?{
        if(isEmpty()) return null
        var currentNode = head
        var currentIndex = 0
        while(currentNode!=null && currentIndex< index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }
    //insert : Adds a value after a particular node
    fun insert(value: T,afterNode: Node<T>): Node<T>{
        if(tail==afterNode){
            append(value)
            return tail!!
        }
        var newNode = Node(value = value,next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }
    //removeFirst : Removes the value at the front of the list
    fun removeFirst(): T?{
        var result = head?.value
        head = head?.next
        if(isEmpty()) tail = null
        return result
    }
    //removeLast: Removes the value at the end of the list
    fun removeLast(): T? {
        val head = head ?: return null
        if(head.next==null) return removeFirst()
        size --
        var prev = head
        var current = head
        var next = current.next

        while(next!=null){
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }
    //removeAfter: Removes the value anywhere in the list
    fun removeAfter(node: Node<T>): T?{
        if(node==tail) return null
        val result = node.next?.value
        if(node.next==tail) {
            tail = node
        }
        if(node.next!=null){
            size --
        }
        node.next = node.next?.next
        return result
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }
    class LinkedListIterator<T>(private val linkedList: LinkedList<T>) : MutableIterator<T>{

        private var index = 0
        private var lastNode: Node<T>? = null

        override fun hasNext(): Boolean {
            return index < linkedList.size
        }
        override fun next(): T {
            if(index>=linkedList.size) throw IndexOutOfBoundsException()
            lastNode = if(index==0){
                linkedList.nodeAt(0)
            }else {
                lastNode?.next
            }
            index++
            return lastNode!!.value
        }
        override fun remove() {

        }
    }
}

data class Node<T>(var value: T,var next: Node<T>? = null){
    override fun toString(): String {
        return if(next!=null){
            "$value -> ${next.toString()}"
        }
        else "$value"

    }
}