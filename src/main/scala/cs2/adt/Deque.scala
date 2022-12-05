package cs2.adt

abstract class Deque[A] {
  def prepend(elem:A) //should add a single element to the logical "beginning" of the Deque
  def append(elem:A) //should add a single element to the logical "end" of the Deque
  def front():A //should return AND remove a single element from the logical "beginning" of the Deque
  def back():A //should return AND remove a single element from the logical "end" of the Deque
  def peekFront():A //should return BUT NOT remove a single element from the logical "beginning"
  def peekBack():A //should return BUT NOT remove a single element from the logical "end"
  def isEmpty():Boolean //should return true if the Deque contains no elements, and false otherwise
  def length(): Int //for testing
}

object Deque {
    def apply[A : Manifest]():Deque[A] = new TheDeque[A]()
}