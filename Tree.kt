package com.mu.jan.dsandalgo
fun main(){
    val tree = TreeNode("Car")

    val treeNode1 = TreeNode("Maruti")
    val treeNode2 = TreeNode("BMW")
    val treeNode3 = TreeNode("Audi")

    tree.add(treeNode1).add(treeNode2).add(treeNode3)
    tree.remove(treeNode2)
    tree.remove()

    treeNode1.add(TreeNode("Maruti 1"))
    treeNode1.remove()


}
class TreeNode<T>(val value: T){
    private var children = mutableListOf<TreeNode<T>>()
    fun add(child: TreeNode<T>): TreeNode<T>{
        children.add(child)
        return this
    }
    //remove children
    fun remove(): TreeNode<T>{
        children = mutableListOf<TreeNode<T>>()
        return this
    }
    //remove child
    fun remove(child: TreeNode<T>): TreeNode<T>{
        if(children.contains(child)) children.remove(child)
        return this
    }
    fun isEmpty(): Boolean{
        return children.size==0
    }
}