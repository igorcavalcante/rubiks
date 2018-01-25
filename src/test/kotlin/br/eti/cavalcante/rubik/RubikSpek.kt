package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Color.*
import br.eti.cavalcante.rubik.Position.*
import org.amshove.kluent.`should equal to`
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class RubikSpek: Spek({

    describe("A Rubik Cube") {

        val front = Face(
            listOf(WHITE, BLUE, ORANGE),
            listOf(RED, YELLOW, RED),
            listOf(RED, RED, RED)
        )

        val bottom = Face(
            listOf(BLUE, WHITE, GREEN),
            listOf(ORANGE, ORANGE, WHITE),
            listOf(BLUE, GREEN, GREEN)
        )

        val cube : Cube = Cube(front, bottom, front, front, front, front)

        on("Moving Down Up Left") {

            val newCube = moveDownUpLeft(cube)

            val shouldFront = Face(
                    listOf(BLUE, BLUE, ORANGE),
                    listOf(ORANGE, YELLOW, RED),
                    listOf(BLUE, RED, RED)
            )

            it("should change the pieces of the left side blocks of the cube") {
                newCube.front `should equal` shouldFront
            }
        }

    }
})