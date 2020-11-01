import soccer.*
import com.soywiz.korge.*
import com.soywiz.korge.tween.tween
import com.soywiz.korge.view.position
import com.soywiz.korim.color.*
import com.soywiz.korma.geom.*
import soccer.fuzzyLogic.space2d.getAngle
import kotlin.random.Random
import soccer.fuzzyLogic.space2d.Point as SPoint


private const val WIDTH = 1024
private const val HEIGHT = 512

suspend fun main() = Korge(width = WIDTH, height = HEIGHT, bgcolor = Colors["#007f00"]) {

	val goalPosition = SPoint(x = 924.0,  y =55.0)
	val goal = goal(goalPosition)

	val ballPosition = SPoint(Random.nextDouble(20.0, WIDTH.toDouble()), Random.nextDouble(20.0, HEIGHT.toDouble()))
	val ball = soccerBall(ballPosition)

	val playerPosition = SPoint(Random.nextDouble(20.0, WIDTH.toDouble()),  Random.nextDouble(20.0, HEIGHT.toDouble()))
	val playerAngle = Random.nextDouble(0.0, 360.0)
	val player = player(playerPosition, playerAngle.degrees)

	println(getAngle(playerPosition, playerAngle, ballPosition))
	println(goalPosition distanceTo ballPosition)

	var count = playerAngle
	while (true) {
		ball.tween()
		player.tween()
		goal.tween()
		count += 10
		println(count)
		player.position(playerPosition.x + 100, playerPosition.y)
	}
}
