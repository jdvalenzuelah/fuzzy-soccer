package soccer.fuzzyLogic.space2d

import com.soywiz.korma.geom.degrees
import kotlin.math.PI
import kotlin.math.atan2

data class RotAngle(val degrees: Double, val orientation: Orientation)

enum class Orientation {
    CW,
    CCW
}

fun getAngle(playerPos: Point, playerAngle: Double, ballPos: Point): RotAngle {
    val (playerX, playerY) = playerPos
    val (ballX, ballY) = ballPos

    val dx = ballX - playerX
    val dy = ballY - playerY

    val shotOrientation = atan2(dy, dx)
            .let {
                if(it < 0)
                    (it + (2 * PI)).degrees.degrees
                else
                    it.degrees.degrees
            }

    val goRight = if(playerAngle >= shotOrientation)
        playerAngle - shotOrientation
    else
        playerAngle - (shotOrientation - 360)

    val goLeft = if(shotOrientation >= playerAngle)
        shotOrientation - playerAngle
    else
        shotOrientation - (playerAngle - 360)

    val orientation = if(goRight <= goLeft) Orientation.CW else Orientation.CCW
    return RotAngle(goLeft, orientation)

}
