package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Color.*
import br.eti.cavalcante.rubik.Position.*
import org.amshove.kluent.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


object FaceSpek : Spek({

    describe("A Face") {

        val face = Face(
            listOf(WHITE, BLUE),
            listOf(RED, ORANGE)
        )

        on("Replacing the first value in the line") {
            val newLine = face.replaceValue(0, face.top, YELLOW)
            it("should change the pieces of the left side blocks of the cube") {
                newLine `should equal` listOf(YELLOW, BLUE)
            }
        }

        on("Replacing the second value in the line") {
            val newLine = face.replaceValue(1, face.bottom, WHITE)

            it("should change the block in to white") {
                newLine `should equal` listOf(RED, WHITE)
            }
        }

        on("Change column left") {
            val newFace = face.replaceLeft(Pair(YELLOW, YELLOW))

            it("should have the new value in the left side of the face") {
                val shouldFace = Face(
                    listOf(YELLOW, BLUE),
                    listOf(YELLOW, ORANGE)
                )

                newFace `should equal` shouldFace
            }
        }

        on("Change column right") {
            val newFace = face.replaceRight(Pair(YELLOW, YELLOW))

            it("should have the new value in the left side of the face") {
                val shouldFace = Face(
                        listOf(WHITE, YELLOW),
                        listOf(RED, YELLOW)
                )

                newFace `should equal` shouldFace
            }
        }

        on("Rotate front left") {
            val newFace = face.rotateFrontLeft()

            it("should generate a new face with the values rotated") {
                val shouldFace = Face(
                        listOf(BLUE, ORANGE),
                        listOf(WHITE, RED)
                )

                newFace `should equal` shouldFace
            }
        }

        on("Rotate front right") {
            val newFace = face.rotateFrontRight()

            it("should generate a new face with the values rotated") {
                val shouldFace = Face(
                        listOf(RED, WHITE),
                        listOf(ORANGE, BLUE)
                )

                newFace `should equal` shouldFace
            }
        }

        on("Comparing equivalent faces") {
            val equivalentFace = Face(
                listOf(WHITE, BLUE),
                listOf(RED, ORANGE)
            )

            it("should be conidered as equals") {
                face `should equal` equivalentFace
            }
        }

        on("Comparing different faces") {
            val different = Face(
                listOf(YELLOW, BLUE),
                listOf(GREEN, ORANGE)
            )

            it("should be considered different") {
                face `should not equal` different
            }
        }

        on("Solved a face") {
            val solvedFace = Face(
                    listOf(YELLOW, YELLOW),
                    listOf(YELLOW, YELLOW)
            )

            it("should mark as solved") {
                solvedFace.solved() `should be` true
            }
        }

        on("Unsolving a face") {
            it("should mark as solved") {
                face.solved() `should be` false
            }
        }

    }
})