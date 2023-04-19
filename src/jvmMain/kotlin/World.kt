import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import kotlin.random.Random.Default.nextFloat

class World {
    var width by mutableStateOf(0.dp)
    var height by mutableStateOf(0.dp)

    var shapes = mutableStateListOf<ShapeData>()

    fun update(time: Long) {
        if (shapes.isEmpty()) {
            (1..(width.value / 5).roundToInt()).forEach { _ ->
                shapes.add(
                    ShapeData(
                        Vector2(width / 2, height / 2),
                        Vector2((6 * nextFloat() - 3).dp, (6 * nextFloat() - 3).dp)
                    )
                )
            }
        }

        shapes.forEach { it.update(0f, this) }
    }

}
