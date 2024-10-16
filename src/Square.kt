import kotlin.math.PI
import kotlin.math.sqrt

class Square(var width: Float=1f, var x: Float=0f, var y: Float=0f) : Transforming, Movable, Figure(0)
{
    override fun area(): Float {
        return width*width.toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int)
    {
        when
        {
            zoom>0 -> width *= sqrt(zoom.toFloat())
            zoom<0 -> width /= sqrt(zoom.toFloat())
        }
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int)
    {
        // Переносим точку так, чтобы центр вращения был в начале координат
        val translatedX = x - centerX
        val translatedY = y - centerY
        val res = width
        when(direction)
        {
            RotateDirection.CounterClockwise -> {x=centerX-translatedY; y=centerY+translatedX; }
            RotateDirection.Clockwise -> {x=centerX+translatedY; y=centerY-translatedX}
        }
    }
}