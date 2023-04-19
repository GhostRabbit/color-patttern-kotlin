import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Shape(shapeData: ShapeData) {
    Box(
        Modifier
            .offset(shapeData.x, shapeData.y)
            .size(shapeData.size)
            .clip(RoundedCornerShape(2.dp))
            .background(shapeData.color)
    )
}