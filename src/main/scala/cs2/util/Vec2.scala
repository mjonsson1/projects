package cs2.util

class Vec2 (var x:Double, var y:Double) {
  /** DO NOT MODIFY THE FOLLOWING TOSTRING METHOD **/
  override def toString():String = "("+x+","+y+")"
  
  //Methods for addition and subtraction of vectors
  def +  (other:Vec2):Vec2 = { ??? }
  def += (other:Vec2):Unit = { ??? }
  
  def -  (other:Vec2):Vec2 = { ??? }
  def -= (other:Vec2):Unit = { ??? }

  //Methods for multiplication and division of vectors by a scalar (non-vector)
  def *  (scalar:Double):Vec2 = { ??? }
  def *= (scalar:Double):Unit = { ??? }

  def /  (scalar:Double):Vec2 = { ??? }
  def /= (scalar:Double):Unit = { ??? }

  //Methods to determine the length of a vector (magnitude and length should return the same value)
  def magnitude():Double = { ??? }
  def length():Double = { ??? }
  
  //Methods to calculate the dot product (same returns)
  def dot(other:Vec2):Double = { ??? }
  def **(other:Vec2):Double = { ??? }
  
  //Methods to determine the angle between 2 vectors (same returns)
  def angleBetween(other:Vec2):Double = { ??? }
  def <>(other:Vec2):Double = { ??? }

  //Methods to return a new vector that is in the same direction, but length 1 (same returns)
  def normalize():Vec2 = { ??? }
  def unary_~ : Vec2 = { ??? }

  //A clone operator can be useful when making "deep" copies of objects
  override def clone():Vec2 = { ??? }
}

object Vec2 {
  //These apply methods can be used for constructing Vec2 instances without saying "new"
  /** DO NOT CHANGE THE FOLLOWING THREE APPLY METHODS**/
  def apply(myX:Double, myY:Double):Vec2 = { new Vec2(myX, myY) }
  def apply(toCopy:Vec2):Vec2 = { new Vec2(toCopy.x, toCopy.y) }
  def apply():Vec2 = { new Vec2(0, 0) }

  def main(args:Array[String]):Unit = {
    /** Your solution to the physics problem described should be calculated here.
     *  Remember to print out your answer using println.
     */
  }
}
