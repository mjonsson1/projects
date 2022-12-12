package cs2.adt

class TheDeque[A: Manifest] extends Deque[A] {
  // Define the required methods and create any neccessary fields here

  private class Node(var data: A, var below: Node, var above: Node)
  private var top: Node = null
  private var bottom: Node = null
  var len: Int = 0



def prepend(elem: A):Unit = {
  if(len == 0) {
    top = new Node(elem, null, null)
    bottom = top
    len += 1
  }

  else{
    top.above = new Node(elem, top, null)
    top = top.above
    len +=1
  }
}
def append(elem: A): Unit = {
  if (len == 0){
  bottom = new Node(elem, null, null)
  top = bottom
  len += 1
  } 
  else{
    bottom.below = new Node(elem, null, bottom)
    bottom = bottom.below
    len += 1
  }
  
}
def peekBack(): A = {
  if(isEmpty()){
  throw new RuntimeException("The DEQueue is Empty")
  }
  else
    bottom.data
}
def peekFront(): A = {
  if(isEmpty()){
  throw new RuntimeException("The DEQueue is Empty")
  }
  else
    top.data
}
def front(): A = {
   if(isEmpty()){
   throw new RuntimeException("The DEQueue is Empty")
   }

   
   else {
    val tmp = top.data
    top = top.below
    len -= 1
    tmp
   }

}
def back(): A = {
   if(isEmpty()){
    throw new RuntimeException("The DEQueue is Empty")
   }

   else {
    val tmp = bottom.data
    bottom = bottom.above
    len -= 1
    tmp
   }
}

def isEmpty():Boolean = {
  var empty = (length == 0)
  empty
}
def length():Int = {
  len
}


def bot(): A = {
  bottom.data
}
def toop(): A = {
  top.data
}



}

/*



object dq { //for testing purposes
  def main(args:Array[String]):Unit={

    var a = new TheDeque[Int]()

    a.prepend(1)
    a.prepend(2)
    a.prepend(3)
    a.prepend(4)


    println(a.front())
    println(a.front())
    println(a.back())
    println(a.back())
    println(a.back())
    println(a.toop())
    println(a.back())
    println(a.back())
    println(a.front())
    println(a.front())
    println(a.isEmpty())
    println(a.length())

  }



}

*/