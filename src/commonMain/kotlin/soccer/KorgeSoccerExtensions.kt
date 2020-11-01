package soccer

import soccer.fuzzyLogic.space2d.Point
import com.soywiz.korge.view.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korma.geom.Angle

suspend fun Container.soccerBall(pos: Point) = soccerBall(pos.x, pos.y)
suspend fun Container.soccerBall(positionX: Double, positionY: Double): Image =
        image(resourcesVfs["ball.png"].readBitmap()) {
            anchor(.5, .5)
            scale(.2)
            position(positionX, positionY)
        }

suspend fun Container.player(pos: Point, rotation: Angle) = player(pos.x, pos.y, rotation)
suspend fun Container.player(positionX: Double, positionY: Double, pRotation: Angle): Image =
        image(resourcesVfs["triangle.png"].readBitmap()) {
            rotation = pRotation
            anchor(.5, .5)
            scale(.15)
            position(positionX, positionY)
        }

suspend fun Container.goal(pos: Point) = goal(pos.x, pos.y)
suspend fun Container.goal(positionX: Double, positionY: Double): Image =
        image(resourcesVfs["goal.png"].readBitmap()) {
            //anchor(.5, .5)
            scale(.5)
            position(positionX, positionY)
        }
