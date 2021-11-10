interface Transforming {
    fun resize(zoomX: Int, zoomY: Int)
    // TODO: величивает фигуру, не перемещая
    fun rotate(direction: RotateDirection, centerX: Int, centerY: Int)
    // TODO: величивает фигуру,
}

enum class RotateDirection {
    // направление вращения фигуры
    Clockwise, CounterClockwise
}
