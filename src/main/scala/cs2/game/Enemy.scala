package cs2.game

import scalafx.scene.image.Image
import cs2.util.Vec2

/** An enemy representation for a simple game based on sprites. Handles all
 *  information regarding the enemy's position, movements, and abilities.
 *
 *  @param pic the image representing the enemy
 *  @param initPos the initial position of the '''center''' of the enemy
 *  @param bulletPic the image of the bullets fired by this enemy
 */
class Enemy(pic:Image, var initPos:Vec2, private val bulletPic:Image) extends Sprite(pic, initPos) {


  private var vel = 1
  def shoot():Bullet = {

    new Bullet(SpriteList.EnemyBullet,new Vec2(initPos.x+23,initPos.y+38), Vec2(0,-6))

   }

  def move(): Unit = {
    if(checkBounds(new Vec2(1080,720))){
      vel *= -1
  }
    initPos.x += vel
    initPos.y += vel
  }


  override def clone():Enemy = {

    var clonedEnemypos:Vec2 = Vec2(this.initPos.x, this.initPos.y)

    var clonedEnemy = new Enemy(SpriteList.AlienShipPurple, clonedEnemypos, SpriteList.EnemyBullet)

    clonedEnemy
  }
  

}
