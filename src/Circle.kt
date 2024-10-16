import kotlin.math.PI

class Circle(var radius: Float=1f, var x: Float=0f, var y: Float=0f) : Movable, Transforming, Figure(0)
{
    constructor(c: Circle) : this(c.radius, c.x, c.y) // Чтобы создавать один круг из другого

    //   Переопределяем функцию родительского класса
    override fun area(): Float {
        return (PI*radius*radius).toFloat()
    }

    // Переопределяем интерфейс movable
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // Переопределяем интерфейс transforming
    override fun resize(zoom: Int)
    {
        when
        {
            zoom>0 -> radius*=zoom
            zoom<0 -> radius/=zoom
        }
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int)
    {
        // Переносим точку так, чтобы центр вращения был в начале координат
        val translatedX = x - centerX
        val translatedY = y - centerY
        when(direction)
        {
            RotateDirection.CounterClockwise -> {x=centerX-translatedY; y=centerY+translatedX}
            RotateDirection.Clockwise -> {x=centerX+translatedY; y=centerY-translatedX}
        }
    }
}