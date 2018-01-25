package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Position.*

enum class Color { WHITE, BLUE, RED, YELLOW, ORANGE, GREEN }
enum class Position { FRONT, BACK, LEFT, RIGHT, TOP, BOTTOM }

typealias Block = Color
typealias Line = List<Block>
typealias Column = Triple<Block, Block, Block>

class Cube(val top: Face, val bottom: Face, val front: Face, val back: Face, val left: Face, val right: Face)

class Face(val top: Line, val middle: Line, val bottom: Line) {

    fun moveDownUpLeft(column: Column) = replaceColumn(0, column)

    private fun replaceColumn(n: Int, c: Column): Face {
        val newTop = replaceValue(n, top, c.first)
        val newMiddle = replaceValue(n, middle, c.second)
        val newBottom = replaceValue(n, bottom, c.third)

        return Face(newTop, newMiddle, newBottom)
    }

    fun replaceValue(n: Int, line: Line, value: Block) = line.take(n) + value + line.drop(n + 1)

    fun getColumn(n: Int) = Triple(top[n], middle[n], bottom[n])

}

fun moveDownUpLeft (cube: Cube) : Cube {
    val front = cube.front
    val bottom = cube.bottom

    val newTop = cube.top
    val newBottom = cube.bottom
    val newFront = front.moveDownUpLeft(bottom.getColumn(0))
    val newBack = cube.back
    val newLeft = cube.left
    val newRight = cube.right
    return Cube(newTop, newBottom, newFront, newBack, newLeft, newRight)
}
/*val moveUpDownRight()
val moveUpDownLeft()
val moveDownUpRight()
val moveLeftRightTop()
val moveLeftRightBottom()
val moveRighLefttTop()
val moveRightLeftBottom()
val moveClockFront()
val moveCounterClockFront()
val moveClockBack()
val moveCounterClockBack()*/
