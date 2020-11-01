package soccer.fuzzyLogic.space2d

import com.soywiz.korma.geom.degrees
import kotlin.math.*

data class Point(val x: Double, val y: Double) {

    infix fun distanceTo(other: Point): Double {
        val (x1, y1) = this
        val (x2, y2) = other
        return sqrt(((x1 - x2).pow(2) + (y1 - y2).pow(2)))
    }

    infix fun shotTo(other: Point): Pair<Shot, Shot> {
        val (x,y) = this
        val (ox, oy) = other

        val dx = ox - x
        val dy = oy - y

        val shotOrientation = atan2(dy, dx)
                .let {
                    if(it < 0)
                        (it + (2 * PI)).degrees
                    else
                        it.degrees
                }
        val xDistance = kotlin.math.abs(x - ox)
        val yDistance = tan(shotOrientation.radians)
        return Shot(shotOrientation.degrees, xDistance) to Shot(shotOrientation.degrees, yDistance)
    }

    infix fun slopeTo(other: Point): Double = (other.y - y) / (other.x - x)

    private fun intercept(other: Point, slope: Double) = other.y - slope * other.y

    infix fun intercept(other: Point): Double = intercept(other, slopeTo(other))

    infix fun slopeInterceptFormTo(other: Point): SlopeInterceptForm {
        val slope = slopeTo(other)
        val intercept = intercept(other, slope)
        return SlopeInterceptForm(slope, intercept)
    }
}
