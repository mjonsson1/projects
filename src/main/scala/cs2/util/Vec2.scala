package cs2.util

class Vec2 (var x:Double, var y:Double) {
  /** DO NOT MODIFY THE FOLLOWING TOSTRING METHOD **/
  override def toString():String = "("+x+","+y+")"
  
  //Methods for addition and subtraction of vectors
  def +  (other:Vec2):Vec2 = {
  val a = this.x + other.x
  val b = this.y +other.y
  Vec2(a,b)
}
  def += (other:Vec2):Unit = { 
  this.x = this.x + other.x
  this.y = this.y +other.y
  }
  
  def -  (other:Vec2):Vec2 = {
  val a = this.x - other.x
  val b = this.y - other.y
  Vec2(a,b)
  }
  def -= (other:Vec2):Unit = { 
  this.x = this.x - other.x
  this.y = this.y - other.y
  }

  //Methods for multiplication and division of vectors by a scalar (non-vector)
  def *  (scalar:Double):Vec2 = { 
  val a = scalar*this.x
  val b = scalar*this.y
  Vec2(a,b)
  }
  def *= (scalar:Double):Unit = { 
  this.x = scalar*this.x
  this.y = scalar*this.y
  }

  def /  (scalar:Double):Vec2 = { 
  val a = this.x/scalar
  val b = this.y/scalar
  Vec2(a,b)
  }
  def /= (scalar:Double):Unit = { 
  this.x = this.x/scalar
  this.y = this.y/scalar
  }

  //Methods to determine the length of a vector (magnitude and length should return the same value)
  def magnitude():Double = { 
  val a = this.x*this.x
  val b = this.y*this.y
  val c = math.sqrt(a+b)
  c
  }
  def length():Double = {
  val a = this.x*this.x
  val b = this.y*this.y
  val c = math.sqrt(a+b)
  c
  }
  
  //Methods to calculate the dot product (same returns)
  def dot(other:Vec2):Double = { this.x*other.x+this.y*other.y}
  def **(other:Vec2):Double = { this.x*other.x+this.y*other.y }
  
  //Methods to determine the angle between 2 vectors (same returns)
  def angleBetween(other:Vec2):Double = {
  val a = this.magnitude()
  val b = other.magnitude()
  val c = this**other
  val d = c/(a*b)
  val e = math.acos(d)
  e
  }
  def <>(other:Vec2):Double = {
  val a = this.magnitude()
  val b = other.magnitude()
  val c = this**other
  val d = c/(a*b)
  val e = math.acos(d)
  e
  }

  //Methods to return a new vector that is in the same direction, but length 1 (same returns)
  def normalize():Vec2 = {
  var a = this.magnitude()
  this.x = this.x / a
  this.y = this.y / a
  this 
}
  def unary_~ : Vec2 = { 
  var a = this.magnitude()
  this.x = this.x / a
  this.y = this.y / a
  this 
}

  //A clone operator can be useful when making "deep" copies of objects
  override def clone():Vec2 = { 
    var clone1 = this
    clone1
   }
}

object Vec2 {
  //These apply methods can be used for constructing Vec2 instances without saying "new"
  /** DO NOT CHANGE THE FOLLOWING THREE APPLY METHODS**/
  def apply(myX:Double, myY:Double):Vec2 = { new Vec2(myX, myY) }
  def apply(toCopy:Vec2):Vec2 = { new Vec2(toCopy.x, toCopy.y) }
  def apply():Vec2 = { new Vec2(0, 0) }

  def main(args:Array[String]):Unit = {
    var a = apply(98.4736,29.4241)
    var b = apply(97.7431,30.2672)
    var distancechange = apply(b.x-a.x,b.y-a.y)
    var speedvector = distancechange/1.5
    var seconddistancechange = speedvector*2.5
    var finalanswer = seconddistancechange+b
    println(finalanswer)
    var c = apply(3,4)
    println(c.normalize())

  }
}

