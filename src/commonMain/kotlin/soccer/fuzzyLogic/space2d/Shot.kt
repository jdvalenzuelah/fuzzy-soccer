package soccer.fuzzyLogic.space2d

import com.soywiz.korma.geom.radians
import kotlin.math.cos
import kotlin.math.sin

data class Shot(val direction: Double, val distance: Double) {
    fun finalPosition(): Point =
            Point(distance * cos(direction.radians.radians), distance * sin(direction.radians.radians))
}
