package br.eti.cavalcante.rubik

import br.eti.cavalcante.rubik.Color.*

val cube = Cube(
        top = Face(
                listOf(ORANGE, ORANGE),
                listOf(RED, YELLOW)
        ),
        bottom = Face(
                listOf(WHITE, GREEN),
                listOf(BLUE, GREEN)
        ),
        front = Face(
                listOf(WHITE, GREEN),
                listOf(GREEN, RED)
        ),
        back = Face(
                listOf(YELLOW, WHITE),
                listOf(WHITE, YELLOW)
        ),
        left = Face(
                listOf(BLUE, BLUE),
                listOf(RED, RED)
        ),
        right = Face(
                listOf(ORANGE, BLUE),
                listOf(YELLOW, ORANGE)
        )
)

val solvedCube = Cube(
        top = Face(
                listOf(RED, RED),
                listOf(RED, RED)
        ),
        bottom = Face(
                listOf(ORANGE, ORANGE),
                listOf(ORANGE, ORANGE)
        ),
        front = Face(
                listOf(WHITE, WHITE),
                listOf(WHITE, WHITE)
        ),
        back = Face(
                listOf(YELLOW, YELLOW),
                listOf(YELLOW, YELLOW)
        ),
        left = Face(
                listOf(BLUE, BLUE),
                listOf(BLUE, BLUE)
        ),
        right = Face(
                listOf(GREEN, GREEN),
                listOf(GREEN, GREEN)
        )
)

val oneToSolveCube = Cube(
        top = Face(
                listOf(WHITE, RED),
                listOf(WHITE, RED)
        ),
        bottom = Face(
                listOf(YELLOW, ORANGE),
                listOf(YELLOW, ORANGE)
        ),
        front = Face(
                listOf(ORANGE, WHITE),
                listOf(ORANGE, WHITE)
        ),
        back = Face(
                listOf(RED, YELLOW),
                listOf(RED, YELLOW)
        ),
        left = Face(
                listOf(BLUE, BLUE),
                listOf(BLUE, BLUE)
        ),
        right = Face(
                listOf(GREEN, GREEN),
                listOf(GREEN, GREEN)
        )
)