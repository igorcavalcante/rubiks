package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Color.*
import br.eti.cavalcante.rubik.Position.*
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class RubikSpek : Spek({

    describe("A Rubik Cube") {

        on("Moving lef down up") {
            val movedCube = cube.moveDownUpLeft()

            it("should move up the left column of the front face") {
                val shouldFront = Face(
                        listOf(WHITE, GREEN),
                        listOf(BLUE, RED)
                )

                movedCube.front `should equal` shouldFront
            }
            it("should move up the left column of the top face") {
                val shouldTop = Face(
                        listOf(WHITE, ORANGE),
                        listOf(GREEN, YELLOW)
                )

                movedCube.top `should equal` shouldTop

            }

            it("should move up the left column of the back face") {
                val shouldBack = Face(
                        listOf(YELLOW, RED),
                        listOf(WHITE, ORANGE)
                )

                movedCube.back `should equal` shouldBack
            }

            it("should move up the left column of the bottom face") {
                val shouldBottom = Face(
                        listOf(YELLOW, GREEN),
                        listOf(WHITE, GREEN)
                )

                movedCube.bottom `should equal` shouldBottom
            }

            it("should rotate left the left face") {
                val shouldLeft = Face(
                        listOf(BLUE, RED),
                        listOf(BLUE, RED)
                )

                movedCube.left `should equal` shouldLeft
            }

            it("should not move the right") {
                movedCube.right `should equal` cube.right
            }

        }

        on("Moving left up down") {
            val movedCube = cube.moveUpDownLeft()

            it("should move up the left column of the front face") {
                val shouldFront = Face(
                        listOf(WHITE, GREEN),
                        listOf(BLUE, RED)
                )

                movedCube.front `should equal` shouldFront
            }
            it("should move up the left column of the top face") {
                val shouldTop = Face(
                        listOf(WHITE, ORANGE),
                        listOf(GREEN, YELLOW)
                )

                movedCube.top `should equal` shouldTop

            }

            it("should move up the left column of the back face") {
                val shouldBack = Face(
                        listOf(YELLOW, RED),
                        listOf(WHITE, ORANGE)
                )

                movedCube.back `should equal` shouldBack
            }

            it("should move up the left column of the bottom face") {
                val shouldBottom = Face(
                        listOf(YELLOW, GREEN),
                        listOf(WHITE, GREEN)
                )

                movedCube.bottom `should equal` shouldBottom
            }

            it("should rotate left the left face") {
                val shouldLeft = Face(
                        listOf(BLUE, RED),
                        listOf(BLUE, RED)
                )

                movedCube.left `should equal` shouldLeft
            }

            it("should not move the right") {
                movedCube.right `should equal` cube.right
            }

        }

    }

})