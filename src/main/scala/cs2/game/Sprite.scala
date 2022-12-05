package cs2.game

import scalafx.scene.image.Image
import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.event.Event
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode

/** A graphical sprite object used for gaming or other visual displays
 *  
 *  @constructor create a new sprite based on the given image and initial location
 *  @param img the image used to display this sprite
 *  @param pos the initial position of the '''center''' of the sprite in 2D space
 */

    




abstract class Sprite (protected val img:Image, protected var pos:Vec2) {

  
  val picture = img
  def move (direction:Vec2):Unit = {
  pos.x +=direction.x
  pos.y -=direction.y
  
   }

  def moveTo (location:Vec2):Unit = {
  pos.x = location.x
  pos.y = location.y
   }
  
  /** Method to display the sprite at its current location in the specified Graphics2D context
   *  
   *  @param g - a GraphicsContext object capable of drawing the sprite
   *  @return none/Unit
   */
  def display (g:GraphicsContext):Unit = {

     g.drawImage(img, pos.x, pos.y)


  }

  def checkBounds(canvasDimensions:Vec2):Boolean = { //Strictly written for enemy motion
    var inBounds = false
    if(pos.x < 0 || pos.x + this.img.width.value > 1280 || pos.y < 0 || pos.y > 2*canvasDimensions.y/5){
      inBounds = true
    }
    inBounds
  }

  def intersection(A:Sprite):Boolean = {
    var hit = false
    val qwidth = this.img.width.value
    val awidth = A.img.width.value
    val qheight = this.img.height.value
    val aheight = A.img.height.value
    val aimg = A.img
    val timg = this.img
    if(((this.pos.x+qwidth > A.pos.x && this.pos.x < A.pos.x+awidth) && (this.pos.y + qheight > A.pos.y && this.pos.y < A.pos.y +aheight)) && (aimg != timg))
      hit=true
    hit
  }


}