package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Color.*
import br.eti.cavalcante.rubik.Position.*
import org.amshove.kluent.`should equal to`
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


object FaceSpek : Spek({

    describe("A Face") {

        val face = Face(
            listOf(WHITE, BLUE, ORANGE),
            listOf(RED, YELLOW, RED),
            listOf(RED, RED, RED)
        )

        on("Replacing the first value in the line") {
            val newLine = face.replaceValue(0, face.middle, WHITE)

            it("should change the pieces of the left side blocks of the cube") {
                newLine `should equal` listOf(WHITE, YELLOW, RED)
            }
        }

        on("Replacing the second value in the line") {
            val newLine = face.replaceValue(1, face.middle, WHITE)

            it("should change the block in to white") {
                newLine `should equal` listOf(RED, WHITE, RED)
            }
        }

        on("Replacing the third value in the line") {
            val newLine = face.replaceValue(2, face.middle, WHITE)

            it("should change the block in to white") {
                newLine `should equal` listOf(RED, YELLOW, WHITE)
            }
        }

    }
})