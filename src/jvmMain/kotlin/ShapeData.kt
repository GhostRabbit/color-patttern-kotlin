import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import kotlin.math.roundToInt
import kotlin.math.sqrt

class ShapeData(val position: Vector2, val velocity: Vector2) {
    var x by mutableStateOf<Dp>(position.x)
    var y by mutableStateOf<Dp>(position.y)
    var color by mutableStateOf<Color>(Color.Black)
    val size = 25.dp

    fun update(realDelta: Float, world: World) {
//        val velocity = movementVector * realDelta.toDouble()
        val width = world.width.value.dp - size
        val height = world.height.value.dp - size
        x += velocity.x
        y += velocity.y
        if (x < 0.dp) {
            x *= -1
            velocity.x *= -1
        } else {
            if (x > width) {
                x = (2 * width) - x
                velocity.x *= -1
            }
        }
        if (y < 0.dp) {
            y *= -1
            velocity.y *= -1
        } else {
            if (y > height) {
                y = (2 * height) - y
                velocity.y *= -1
            }
        }

        val maxD = distance(0f, 0f, width.value, height.value)
        val r = lerp(255, 0, distance(0f, 0f, x.value, y.value) / maxD)
        val g = lerp(255, 0, distance(width.value, 0f, x.value, y.value) / maxD)
        val b = lerp(255, 0, distance(width.value, height.value, x.value, y.value) / maxD)
        color = Color(r, g, b, 128)
    }

    private fun distance(x1: Float, y1: Float, x2: Float, y2: Float): Float {
        return sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)))
    }

    private fun lerp(start: Int, stop: Int, fraction: Float): Int {
        return (start + fraction * (stop - start)).roundToInt()
    }

}
