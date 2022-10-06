package cs2.game

import scalafx.scene.image.Image
import cs2.util.Vec2

/** The player representation for a simple game based on sprites. Handles all
 *  information regarding the player's positions, movements, and abilities.
 *
 *  @param avatar the image representing the player
 *  @param initPos the initial position of the '''center''' of the player
 *  @param bulletPic the image of the bullets fired by this player
 */
class Player(var avatar:Image, var initPos:Vec2, private val bulletPic:Image) extends Sprite(avatar, initPos) {

  val vel = Vec2(10,10)


  /** moves the player sprite one "step" to the left.  The amount of this
   *  movement will likely need to be tweaked in order for the movement to feel
   *  natural.
   *
   *  @return none/Unit
   */
  def moveLeft():Unit = {
  

    if(initPos.x>10){
    initPos.x-=vel.x
  }
    else
    initPos.x=initPos.x
  
}
  /** moves the player sprite one "step" to the right (see note above)
   *
   *  
   */
  def moveRight():Unit = {  
    if(initPos.x<1220){
    initPos.x = initPos.x + vel.x
    }
    else
    initPos.x = initPos.x
}
  def moveUp():Unit = {
    if(initPos.y>10){
    initPos.y -= vel.y
    }
    else
    initPos.y = initPos.y
  }
  def moveDown():Unit = {
    if(initPos.y<790){
    initPos.y += vel.y
    }
    else
    initPos.y = initPos.y
  }

  

  /** creates a new Bullet instance beginning from the player, with an
   *  appropriate velocity
   *
   *  @return Bullet - the newly created Bullet object that was fired
   */
  def shoot():Bullet = { 

    new Bullet(bulletPic, new Vec2(initPos.x,initPos.y-10), Vec2(0,20))
  
  }
  

}
