class Rect(var x: Int, var y: Int, val width: Int, val height: Int) : Movable, Figure(0) {
    var color: Int = -1
    lateinit var name: String // значение на момент определения неизвестно
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat()
    }
}