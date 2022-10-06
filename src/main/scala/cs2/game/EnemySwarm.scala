package cs2.game

import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2
import scala.util.Random

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

  var EnemyList = List[Enemy]()
  for(r <- 1 to nRows;c<- 1 to nCols){
  EnemyList ::= new Enemy(SpriteList.AlienShipPurple, new Vec2(182*r-25,80*c), SpriteList.EnemyBullet)
  }

  def display(g:GraphicsContext):Unit = {
  EnemyList.foreach(_.display(g))
  }

  /** overridden method of ShootsBullets. Creates a single, new bullet instance
   *  originating from a random enemy in the swarm. (Not a bullet from every
   *  object, just a single from a random enemy)
   *
   *  @return Bullet - the newly created Bullet object fired from the swarm
   */
  def swarmshoot():Bullet = { 
    EnemyList((math.random*EnemyList.length).toInt).shoot()
   }

}
