// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
import kotlin.math.sqrt
class Rect(var x: Float, var y: Float, var width: Float, var height: Float) : Movable, Transforming, Figure(0) {

    var color: Int = -1

    lateinit var name: String

    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }


    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Int)
    {
        when
        {
            zoom>0 -> {width *= sqrt(zoom.toFloat()); height *= sqrt(zoom.toFloat())}
            zoom<0 -> {width /= sqrt(zoom.toFloat()); height /= sqrt(zoom.toFloat())}
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
        width = height
        height = res
    }
}