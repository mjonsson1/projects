package cs2.game

import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2
import scala.util.Random
import scala.collection.mutable.Buffer
import scalafx.scene.input.KeyCode

/** contains the control and logic to present a coordinated set of Enemy objects.
 *  For now, this class generates a "grid" of enemy objects centered near the
 *  top of the screen.
 *
 *  @param nRows - number of rows of enemy objects //we want 3 rows of 6 enemies  spread evenly//
 *  @param nCols - number of columns of enemy objects
 */
class EnemySwarm(private val nRows:Int, private val nCols:Int) {
  /** method to display all Enemy objects contained within this EnemySwarm
   *
   *  @param g - the GraphicsContext to draw into
   *  @return none/Unit
   */

  var EnemyBuffer = Buffer[Enemy]()
  for(r <- 1 to nRows;c<- 1 to nCols){
  EnemyBuffer += new Enemy(SpriteList.AlienShipPurple, new Vec2(182*r-25,80*c), SpriteList.EnemyBullet)
  }

  def display(g:GraphicsContext):Unit = {
  EnemyBuffer.foreach(_.display(g))
  }

  def swarmshoot():Bullet = { 
    EnemyBuffer((math.random*EnemyBuffer.length).toInt).shoot()
   }

  def enemyHit(A:Sprite): Boolean = {
    val plp = SpriteList.SpaceCraft //Player img pic
    val pbp = SpriteList.GamerBullet // player bullet pic, need to specify that only player bullets have this action
    var EnemyRemoveBuffer =  Buffer[Enemy]()
    var wasHit = false
    for(Enemy <- EnemyBuffer){
      if(Enemy.intersection(A) && (A.picture == pbp)) { 
        EnemyRemoveBuffer+= Enemy
        wasHit = true
      }
    }
      EnemyBuffer --= EnemyRemoveBuffer
      wasHit
   }
   def enemyBump(A:Sprite): Boolean = {
      val plp = SpriteList.SpaceCraft
      var wasBumped = false
      for(Enemy <- EnemyBuffer){
        if(Enemy.intersection(A) && A.picture == plp){
          wasBumped = true
        }
      }
      wasBumped
   }

   def isEmpty():Boolean = {
    var empty = false
    if(EnemyBuffer.length == 0)
    empty = true
    empty
   }

}