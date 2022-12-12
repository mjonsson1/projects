package cs2.adt

class DEPQ[A <% Ordered[A]] extends DoubleEndPriorityQueue[A] {



    private class Node(var data:A , var below:Node, var above:Node)

    private var top:Node = null
    private var bottom:Node = null
    private  var len: Int = 0



  def isEmpty():Boolean = {
    var empty =  (len == 0)
    empty
  }



  def add(elem: A):Unit = {
    if (len == 0){
    top = new Node(elem, null, null)
    bottom = top
    len+=1
    }
    else{
        var rover = top
        if(rover.data < elem){
        rover.above = new Node(elem, rover, null)
        top = rover.above
        len += 1
        }
        else{
            while(rover.below != null && rover.below.data > elem){
                rover = rover.below
                len += 1
            }

            if(rover.below == null){
                rover.below = new Node(elem, null, rover)
                bottom = rover.below
                len += 1
            }
            else{
                rover.below = new Node(elem, rover.below, rover)
                len +=1
            }
        }
    }
}
  def peekMax():A = {

    if (isEmpty()){
        throw new RuntimeException(" The DEPQueue is Empty")
    }

    top.data
  }
  def max():A = {

    if (isEmpty()){
        throw new RuntimeException(" The DEPQueue is Empty")
    }
    else{
    val tmp = top.data
    top = top.below
    len -=1 
    tmp
    }

  }
  def peekMin():A = {

    if (isEmpty()){
        throw new RuntimeException(" The DEPQueue is Empty")
    }

    bottom.data
  }
  def min():A = {
    if (isEmpty()){
        throw new RuntimeException(" The DEPQueue is Empty")
    }
    else {
        val tmp = bottom.data
        bottom = bottom.above
        len -=1
        tmp
    }
  }
}