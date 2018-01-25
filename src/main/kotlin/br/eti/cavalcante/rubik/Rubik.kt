package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Position.*

enum class Color { WHITE, BLUE, RED, YELLOW, ORANGE, GREEN }
enum class Position { FRONT, BACK, LEFT, RIGHT, TOP, BOTTOM }

typealias Block = Color
typealias Line = List<Block>
typealias Column = Pair<Block, Block>

class Cube(val top: Face, val bottom: Face, val front: Face, val back: Face, val left: Face, val right: Face)

class Face(val top: Line, val bottom: Line) {

    fun replaceLeft(column: Column) = replaceColumn(0, column)

    fun replaceRight(column: Column) = replaceColumn(1, column)

    fun rotateFrontLeft() : Face {
        val newTop = listOf(top[1], bottom[1])
        val newBottom = listOf(top[0], bottom[0])

        return Face(newTop, newBottom)
    }

    fun rotateFrontRight() : Face {
        val newTop = listOf(bottom[0], top[0])
        val newBottom = listOf(bottom[1], top[1])

        return Face(newTop, newBottom)
    }

    private fun replaceColumn(n: Int, c: Column): Face {
        val newTop = replaceValue(n, top, c.first)
        val newBottom = replaceValue(n, bottom, c.second)
        return Face(newTop, newBottom)
    }

    fun replaceValue(n: Int, line: Line, value: Block) = line.take(n) + value + line.drop(n + 1)

    fun getColumn(n: Int) = Pair(top[n], bottom[n])

    override fun toString(): String =
        "\n[${top[0]}][${top[1]}]" +
        "\n[${bottom[0]}][${bottom[1]}]\n"

    override fun equals(other: Any?) =
        if(other is Face) top == other.top && bottom == other.bottom
        else false

}

//fun moveDownUpLeft (cube: Cube) : Cube {
/*    val front = cube.front
    val bottom = cube.bottom

    val newTop = cube.top
    val newBottom = cube.bottom
    val newFront = front.moveDownUpLeft(bottom.getColumn(0))
    val newBack = cube.back
    val newLeft = cube.left
    val newRight = cube.right
    return Cube(newTop, newBottom, newFront, newBack, newLeft, newRight)*/
//}
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
