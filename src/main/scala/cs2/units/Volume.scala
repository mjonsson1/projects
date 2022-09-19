package cs2.units

class Volume() {
  //Field - the volume stored in LITERS
  private var lit:Double = 0.0

  //Basic math operators to add, subtract, and scale volumes
  def + (other:Volume):Volume = { 
    this.lit=this.lit + other.lit
    return Volume(this.lit)
  }
  def += (other:Volume):Unit  = { this.lit = this.lit + other.lit }

  def - (other:Volume):Volume = { 
    this.lit=this.lit - other.lit
    return Volume(this.lit)
  }
  def -= (other:Volume):Unit  = { this.lit = this.lit-other.lit}

  def * (scalar:Double):Volume = { 
    this.lit=this.lit*scalar 
    return Volume(this.lit)
  }
  def *= (scalar:Double):Unit  = { this.lit=this.lit*scalar}

  def / (scalar:Double):Volume = { 
    this.lit=this.lit/scalar
    return Volume(this.lit)
  }
  def /= (scalar:Double):Unit  = { this.lit=this.lit/scalar}

  //Getter functions that return in a variety of units
  def liters():Double = {
    return this.lit
  }
  def milliliters():Double = {
    val tmp = this.lit
    return tmp*1000
  }
  def gallons():Double = { 
    val tmp = this.lit
    return tmp*3.78541
  }
  def quarts():Double = { 
    val tmp = this.lit
    return tmp*1.0567
  }
  def pints():Double = { 
    val tmp = this.lit
    return tmp*2.113376
  }
  def cups():Double = { 
    val tmp = this.lit
    return tmp*4.2268
   }
  def teaspoons():Double = { 
    val tmp = this.lit
    return tmp*202.88
  }
  def tablespoons():Double = {
    val tmp = this.lit
    return tmp*67.628
  }

  override def toString():String = lit.toString

}


object Volume {
  //"Constructor" apply methods operating in liters
  def apply():Volume = { new Volume() }
  def apply(amt:Double):Volume = { 
    var a = new Volume()
    a.lit = a.lit + amt
    return a
  }
  

  //Alternative "static" methods to create volumes in other units
  def liters(amt:Double):Volume = { 
  val  tmp = apply(amt)
  tmp 
  } //identical to an apply method
  def milliliters(amt:Double):Volume = { 
  val tmp:Volume = apply(amt*1000)
  tmp
  }
  def gallons(amt:Double):Volume = {
  val tmp:Volume = apply(amt*3.78541)
  tmp
  }
  def quarts(amt:Double):Volume = {
  val tmp = gallons(amt)*4 
  tmp
  }
  def pints(amt:Double):Volume = { 
  val tmp = gallons(amt)*8
  tmp
  }
  def cups(amt:Double):Volume = { 
  val tmp = gallons(amt)*16
  tmp
  }
  def teaspoons(amt:Double):Volume = {
  val tmp:Volume = apply(amt*202.884)
  tmp
  }
  def tablespoons(amt:Double):Volume = { 
  val tmp:Volume = apply(amt*67.628)
  tmp
  }

/* TESTER FUNCTION :)
  def main(args:Array[String]):Unit = {
    println(apply(3))
    var a = apply(41.2)
    var b = apply(30.4)
    println(apply(3).tablespoons())
    println(teaspoons(41.2))
    println((a+b).gallons())

  }
*/
}
