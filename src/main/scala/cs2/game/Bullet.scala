package cs2.game

import scalafx.scene.image.Image
import cs2.util.Vec2
import scalafx.event.Event
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode

/** Representation of a bullet/projectile for a simple game based on sprites.
 *  Handles all information regarding a bullet's position, movements, and 
 *  abilities.
 *  
 *  @param pic the image representing the bullet
 *  @param initPos the initial position of the '''center''' of the bullet
 *  @param vel the initial velocity of the bullet
 */
class Bullet(val pic:Image, var initPos:Vec2, private var vel:Vec2) extends Sprite(pic, initPos) {

var velocity = vel
  /** advances the position of the Bullet over a single time step
   * 
   *  @return none/Unit
   */
  def timeStep():Unit = {

    if(initPos.y>= -50){
    initPos.x+=vel.x
    initPos.y-=vel.y
    }

  }

  override def clone():Bullet = {


    var clonedpos = new Vec2(this.pos.x,this.pos.y)

    var bulletclone = new Bullet(pic, clonedpos, vel)

    bulletclone
  }

  
}