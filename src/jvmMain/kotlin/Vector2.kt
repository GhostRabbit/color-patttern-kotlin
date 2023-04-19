import androidx.compose.ui.unit.Dp

data class Vector2(var x:Dp, var y:Dp) {
    fun plus(other: Vector2) {
        this.x += other.x
        this.y += other.y
    }

}
