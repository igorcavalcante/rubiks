package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Position.*

enum class Color(val ansiColor: String) {
    WHITE("\u001B[47m"),
    BLUE("\u001B[44m"),
    RED("\u001B[41m"),
    YELLOW("\u001B[43m"),
    ORANGE("\u001b[48;5;202m"),
    GREEN("\u001B[42m");

    override fun toString() = "${this.ansiColor}  \u001B[0m"
}
enum class Position { FRONT, BACK, LEFT, RIGHT, TOP, BOTTOM }

typealias Block = Color
typealias Line = List<Block>
typealias Column = Pair<Block, Block>

class Cube(val top: Face, val bottom: Face, val front: Face, val back: Face, val left: Face, val right: Face) {

    val moveDownUpLeft = {
        val newFront = front.replaceLeft(bottom.getColumn(0))
        val newTop = top.replaceLeft(front.getColumn(0))
        val newBack = back.replaceRight(top.getInvertedColumn(0))
        val newBottom = bottom.replaceLeft(back.getColumn(0))
        val newLeft = left.rotateFrontLeft()

        Cube(newTop, newBottom, newFront, newBack, newLeft, right)
    }

    val moveUpDownLeft = {
        val newFront = front.replaceLeft(bottom.getColumn(0))
        val newTop = top.replaceLeft(front.getColumn(0))
        val newBack = back.replaceRight(top.getInvertedColumn(0))
        val newBottom = bottom.replaceLeft(back.getColumn(0))
        val newLeft = left.rotateFrontLeft()

//        Cube(newTop, newBottom, newFront, newBack, newLeft, right)
        this
    }

}

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

    fun getInvertedColumn(n: Int) = Pair(bottom[n], top[n])

    override fun toString() =
        "\n${top[0]}${top[1]}" +
        "\n${bottom[0]}${bottom[1]}\n\u001B[0m"

    override fun equals(other: Any?) =
        if(other is Face) top == other.top && bottom == other.bottom
        else false

    fun solved(): Boolean {
        val block = top.first()
        return (top.all { it == block } && bottom.all { it == block })
    }
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
