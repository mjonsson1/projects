package cs2.units

class Volume() {
  //Field - the volume stored in LITERS
  private var lit:Double = 0.0

  //Basic math operators to add, subtract, and scale volumes
  def + (other:Volume):Volume = { ??? }
  def += (other:Volume):Unit  = { ??? }

  def - (other:Volume):Volume = { ??? }
  def -= (other:Volume):Unit  = { ??? }

  def * (scalar:Double):Volume = { ??? }
  def *= (scalar:Double):Unit  = { ??? }

  def / (scalar:Double):Volume = { ??? }
  def /= (scalar:Double):Unit  = { ??? }

  //Getter functions that return in a variety of units
  def liters():Double = { ??? }
  def milliliters():Double = { ??? }
  def gallons():Double = { ??? }
  def quarts():Double = { ??? }
  def pints():Double = { ??? }
  def cups():Double = { ??? }
  def teaspoons():Double = { ??? }
  def tablespoons():Double = { ??? }
}

object Volume {
  //"Constructor" apply methods operating in liters
  def apply():Volume = { ??? }
  def apply(amt:Double):Volume = { ??? }

  //Alternative "static" methods to create volumes in other units
  def liters(amt:Double):Volume = { ??? } //identical to an apply method
  def milliliters(amt:Double):Volume = { ??? }
  def gallons(amt:Double):Volume = { ??? }
  def quarts(amt:Double):Volume = { ??? }
  def pints(amt:Double):Volume = { ??? }
  def cups(amt:Double):Volume = { ??? }
  def teaspoons(amt:Double):Volume = { ??? }
  def tablespoons(amt:Double):Volume = { ??? }
}

