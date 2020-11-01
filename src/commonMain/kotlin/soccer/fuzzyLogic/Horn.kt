package soccer.fuzzyLogic

import soccer.fuzzyLogic.space2d.Point

typealias DoubleGen = (Double) -> Double
object Horn {
    fun or(f1: DoubleGen, f2: DoubleGen, f3: DoubleGen): (Double, Double, Double) -> Double {
        return fun(ds: Double, rs: Double, es: Double): Double =
                kotlin.math.min(kotlin.math.max(f1(ds), f2(rs)), f3(es))
    }

    fun and(f1: DoubleGen, f2: DoubleGen, f3: DoubleGen): (Double, Double, Double) -> Double {
        return fun(ds: Double, rs: Double, es: Double): Double =
                kotlin.math.min(kotlin.math.min(f1(ds), f2(rs)), f3(es))
    }
}


fun generateFunction(p1: Point, p2: Point, p3: Point, p4: Point): (Double) -> Double {
    val (m1, b1) = p1 slopeInterceptFormTo p2
    val (m2, b2) = p2 slopeInterceptFormTo p3
    val (m3, b3) = p3 slopeInterceptFormTo p4

    return fun (d: Double): Double =
            when {
                d > p3.x -> d * m3 + b3
                d > p2.x -> d * m2 + b2
                else -> d * m1 + b1
            }

}
