package cs2.game

import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.event.Event
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import scalafx.scene.effect.Effect
import scalafx.animation.AnimationTimer
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.text.Font
import scalafx.scene.text.Text
import scalafx.geometry.Pos
import scalafx.geometry.Pos.TopCenter
import scalafx.scene.text.TextAlignment
import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2
import javax.net.ssl.TrustManager
import java.awt.RenderingHints.Key
import scala.collection.mutable.Buffer
import scala.collection.mutable.Set




/** main object that initiates the execution of the game, including construction
 *  of the window.
 *  Will create the stage, scene, and canvas to draw upon. Will likely contain or
 *  refer to an AnimationTimer to control the flow of the game.
 */
object SpaceGameApp extends JFXApp {



    val Gamer = new Player(SpriteList.SpaceCraft, new Vec2(615,720), SpriteList.GamerBullet)
    val GamerBullet = new Bullet(SpriteList.GamerBullet, new Vec2(Gamer.initPos.x,Gamer.initPos.y+100), Vec2(0,2.5))
    //val Evil = new Enemy(SpriteList.AlienShipPurple, new Vec2(300,300), SpriteList.EnemyBullet)
    //val EnemyBullet = new Bullet(SpriteList.EnemyBullet, new Vec2(Enemy.initPos.x,Enemy.initPos.y), Vec2(0,2.5))
    var Swarm = new EnemySwarm(6,3)

    var BulletBuffer = Buffer[Bullet]()
    //var EnemyBulletBuffer = Buffer[Bullet]()
    var EnemySwarmBuffer = Buffer[Enemy]()
    var KeysTrackedSet = Set[KeyCode]()
    var BulletRemoveBuffer = Buffer[Bullet]()
    
    stage = new JFXApp.PrimaryStage {
        title = "Knockoff Galaga XD!"
        scene = new Scene(1280,800) {
            val canvas = new Canvas(1280,800)
            content = canvas
            val g = canvas.graphicsContext2D


            
            val TitleScreen = g.setTextAlign(TextAlignment.Center);g.setFill(CustomColors.background);g.fillRect(0,0, canvas.width.value,canvas.height.value);g.setStroke(Color.LightYellow);g.setFont(FontsLoaded.GemunuLibreEB);g.strokeText("San Antonio Space Invaders", canvas.width.value/2,canvas.height.value-600, 400);g.setFont(FontsLoaded.GemunuLibreMed);g.setFill(Color.LightYellow);g.fillText("Press Enter Key to Play", canvas.width.value/2, canvas.height.value-200, 200)
            //val Caption = g.setFont(FontsLoaded.GemunuLibreMed);g.setFill(Color.LightYellow);g.fillText("Press Enter Key to Play", canvas.width.value/2, canvas.height.value-200, 200)
            //val PauseScreen = g.setFill(CustomColors.pausescreenbg);g.fillRect(0,0, canvas.width.value, canvas.height.value);g.strokeText("Quit Game?", canvas.width.value/2, canvas.height.value-550, 400)
        
            canvas.requestFocus()

            var enter = 0
            var escape = 0

                canvas.onKeyPressed = (e:KeyEvent) => {
                if(e.code == KeyCode.Enter){
                enter += 1
                }
                
                if(e.code == KeyCode.Escape){
                escape += 1
                } 

                if (e.code == KeyCode.Left){
                KeysTrackedSet+=KeyCode.Left
                Gamer.moveLeft()
                }

                if (e.code == KeyCode.Right){
                KeysTrackedSet+=KeyCode.Right
                Gamer.moveRight()
                }
                if (e.code == KeyCode.Up){
                KeysTrackedSet+=KeyCode.Up
                Gamer.moveUp()
                }
                if (e.code == KeyCode.Down){
                KeysTrackedSet+=KeyCode.Down
                Gamer.moveDown()
                }
                
                if (e.code == KeyCode.Space){
                KeysTrackedSet+=KeyCode.Space
                //BulletBuffer += Gamer.shoot()
                }

                if (e.code == KeyCode.T){
                    Gamer.moveTo(Vec2(615,720))
                }
                
            }
                canvas.onKeyReleased = (e:KeyEvent) => {
                if(e.code == KeyCode.Left){
                KeysTrackedSet -= KeyCode.Left
                }
                if(e.code == KeyCode.Right){
                KeysTrackedSet -= KeyCode.Right
                }
                if(e.code == KeyCode.Up){
                KeysTrackedSet -= KeyCode.Up
                }
                if(e.code == KeyCode.Down){
                KeysTrackedSet -= KeyCode.Down
                }
                if(e.code == KeyCode.Space){
                KeysTrackedSet -=KeyCode.Space
                }
                }


            var slowdown = 0
            var enemyslowdown = 0
            val timer = AnimationTimer(t=>{

                if(enter == 0){
                TitleScreen
                }
                //if(enter>=1){
                //Caption
                //}

                if(KeysTrackedSet.contains(KeyCode.Left)){
                Gamer.moveLeft()
                }
                if(KeysTrackedSet.contains(KeyCode.Right)){
                Gamer.moveRight()
                }
                if(KeysTrackedSet.contains(KeyCode.Up)){
                Gamer.moveUp()
                }
                if(KeysTrackedSet.contains(KeyCode.Down)){
                Gamer.moveDown()
                }

                if(KeysTrackedSet.contains(KeyCode.Space)){
                slowdown +=1
                if (slowdown > 0){
                slowdown = -15
                BulletBuffer += Gamer.shoot()
                }
                
                }//MACHINE GUN POWER UP LOL but only if without slowdown
                
                if(enter >= 1){
                g.setFill(CustomColors.background);g.fillRect(0,0, canvas.width.value,canvas.height.value)
                Gamer.display(g)
                Swarm.display(g)
                enemyslowdown+=1
                    /*if(escape >= 1){
                    g.setFill(CustomColors.pausescreenbg);g.fillRect(0,0, canvas.width.value, canvas.height.value);g.strokeText("Quit Game?", canvas.width.value/2, canvas.height.value-550, 400)*///THIS IS PAUSE SCREEN CODE
                }
                //println(Gamer.initPos.x.toString())
                //println(Gamer.initPos.y.toString())
                
                
                if(enemyslowdown > 0){
                enemyslowdown = -45
                BulletBuffer += Swarm.swarmshoot()
                }
                
                for(Bullet <- BulletBuffer){
                    Bullet.display(g)
                    Bullet.timeStep() 
                }

                for(i <- 0 until BulletBuffer.length){
                if(BulletBuffer(i).initPos.y> 830 || BulletBuffer(i).initPos.y < -30)
                    BulletRemoveBuffer+= BulletBuffer(i)
                
                val ebp = SpriteList.EnemyBullet //enemy bullet pic, need it to specify that only enemy bullets have this action
                if(Gamer.intersection(BulletBuffer(i)) && BulletBuffer(i).pic == ebp){
                    Gamer.moveTo(Vec2(615,720))
                    BulletRemoveBuffer+=BulletBuffer(i)
                }
            }
                BulletBuffer --= BulletRemoveBuffer
                for(i <- 0 until BulletBuffer.length){
                    //Swarm.enemyHit(BulletBuffer(i))
                if(Swarm.enemyHit(BulletBuffer(i))){
                    BulletRemoveBuffer+=BulletBuffer(i)
                }
                if(Swarm.enemyBump(Gamer)){
                    Gamer.moveTo(Vec2(615,720))
                }
                
                //println(escape)
                //println(enter)
                //println(KeysTrackedSet)
                println(enemyslowdown)
                for(j <- 0 until BulletBuffer.length){
                    if(i != j){
                        if((BulletBuffer(i).intersection(BulletBuffer(j)))){
                                BulletRemoveBuffer +=BulletBuffer(i)
                                BulletRemoveBuffer += BulletBuffer(j)
                        }
                    }
                    //println(BulletBuffer(i).pic != BulletBuffer(j).pic)
                }
                
                }
                BulletBuffer --= BulletRemoveBuffer


                if (Swarm.isEmpty()){
            
                Swarm = new EnemySwarm(6,3)
                Swarm.display(g)
                }


            })

            timer.start()
            canvas.requestFocus()

        }

    }

}

object FontsLoaded  {
    val path1 = getClass().getResource("/GemunuLibre/GemunuLibre-Medium.ttf").toString()
    val GemunuLibreMed = Font.loadFont(path1, 25)
    val path2 = getClass().getResource("/GemunuLibre/GemunuLibre-ExtraLight.ttf").toString()
    val GemunuLibreExLi = Font.loadFont(path2, 40)
    val path3 = getClass().getResource("/GemunuLibre/GemunuLibre-Light.ttf").toString()
    val GemunuLibreLight = Font.loadFont(path3, 40)
    val path4 = getClass().getResource("/GemunuLibre/GemunuLibre-Regular.ttf").toString()
    val GemunuLibreReg = Font.loadFont(path4, 40)
    val path5 = getClass().getResource("/GemunuLibre/GemunuLibre-SemiBold.ttf").toString()
    val GemunuLibreSB = Font.loadFont(path5, 40)
    val path6 = getClass().getResource("/GemunuLibre/GemunuLibre-Bold.ttf").toString()
    val GemunuLibreBold = Font.loadFont(path6, 40)
    val path7 = getClass().getResource("/GemunuLibre/GemunuLibre-ExtraBold.ttf").toString
    val GemunuLibreEB = Font.loadFont(path7, 40)
            
            

}


object CustomColors {
    val background:Color = Color.hsb(230,1,0.1)
    val pausescreenbg:Color = Color.Black
}

object SpriteList {
    val SpaceCraftpath = getClass().getResource("/Sprites/Spacecraft.png")
    val SpaceCraft = new Image(SpaceCraftpath.toString())

    val GamerBulletpath = getClass().getResource("/LaserSprite/BlueLaser.png")
    val GamerBullet = new Image(GamerBulletpath.toString())

    val EnemyBulletpath = getClass().getResource("/LaserSprite/RedLaser.png")
    val EnemyBullet = new Image(EnemyBulletpath.toString())

    val AlienShipPurplepath = getClass().getResource("/Sprites/AlienShipPurple.png")
    val AlienShipPurple = new Image(AlienShipPurplepath.toString())

    val AlienShipWhitepath = getClass().getResource("/Sprites/AlienShipWhite.png")
    val AlienShipWhite = new Image(AlienShipPurplepath.toString())

}