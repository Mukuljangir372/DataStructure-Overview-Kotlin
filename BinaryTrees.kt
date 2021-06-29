package com.mu.jan.dsandalgo

fun main(){
    val binaryTree = BinaryNode("hand")
    binaryTree.leftNode = BinaryNode("left hand")
    binaryTree.rightNode = BinaryNode("right hand")
}
class BinaryNode<T>(var value: T){
    var leftNode: BinaryNode<T>? = null
    var rightNode: BinaryNode<T>? = null
}
