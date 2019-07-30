package nad.chessboard.services

import nad.chessboard.services.Side.BLACK
import nad.chessboard.services.Side.WHITE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class BoardTest {
    private var subject = Board()

    @Test
    fun testConstructor_emptyBoard() {
        for (column in 1..8) {
            for (row in 1..8) {
                verifyEmptySquare(subject.at(column, row))
            }
        }
    }

    @Test
    fun testResetToStartingPosition() {
        subject.resetToStartingPosition()

        verifySquare(subject.at(1, 1), Piece(PieceType.ROOK, WHITE))
        verifySquare(subject.at(2, 1), Piece(PieceType.KNIGHT, WHITE))
        verifySquare(subject.at(3, 1), Piece(PieceType.WHITE_BISHOP, WHITE))
        verifySquare(subject.at(4, 1), Piece(PieceType.QUEEN, WHITE))
        verifySquare(subject.at(5, 1), Piece(PieceType.KING, WHITE))
        verifySquare(subject.at(6, 1), Piece(PieceType.BLACK_BISHOP, WHITE))
        verifySquare(subject.at(7, 1), Piece(PieceType.KNIGHT, WHITE))
        verifySquare(subject.at(8, 1), Piece(PieceType.ROOK, WHITE))
        verifySquare(subject.at(1, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(2, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(3, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(4, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(5, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(6, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(7, 2), Piece(PieceType.PAWN, WHITE))
        verifySquare(subject.at(8, 2), Piece(PieceType.PAWN, WHITE))

        for (column in 1..8) {
            for (row in 3..6) {
                verifyEmptySquare(subject.at(column, row))
            }
        }

        verifySquare(subject.at(1, 8), Piece(PieceType.ROOK, BLACK))
        verifySquare(subject.at(2, 8), Piece(PieceType.KNIGHT, BLACK))
        verifySquare(subject.at(3, 8), Piece(PieceType.BLACK_BISHOP, BLACK))
        verifySquare(subject.at(4, 8), Piece(PieceType.QUEEN, BLACK))
        verifySquare(subject.at(5, 8), Piece(PieceType.KING, BLACK))
        verifySquare(subject.at(6, 8), Piece(PieceType.WHITE_BISHOP, BLACK))
        verifySquare(subject.at(7, 8), Piece(PieceType.KNIGHT, BLACK))
        verifySquare(subject.at(8, 8), Piece(PieceType.ROOK, BLACK))
        verifySquare(subject.at(1, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(2, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(3, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(4, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(5, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(6, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(7, 7), Piece(PieceType.PAWN, BLACK))
        verifySquare(subject.at(8, 7), Piece(PieceType.PAWN, BLACK))
    }

    @Test
    fun testAtPut() {
        subject.atPut(4, 4, Piece(PieceType.KING, BLACK))

        assertEquals(subject.at(4, 4)!!.piece, Piece(PieceType.KING, BLACK))
    }

    @Test
    fun testAtPut_noPiece() {
        subject.atPut(4, 4, NoPiece)

        verifyEmptySquare(subject.at(4, 4))
    }

    private fun verifyEmptySquare(square: Square?) {
        assertNotNull(square)

        square?.let {
            assertTrue("$square is supposed to be empty", square.isEmpty)
        }
    }

    private fun verifySquare(square: Square?, piece: Piece) {
        assertNotNull(square)

        square?.let {
            assertEquals(piece, square.piece)
        }
    }
}
