package nad.chessboard.services

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PieceTest {
    private lateinit var subject: Piece

    @Test
    fun testConstruct_whitePawn() {
        subject = Piece(PieceType.PAWN, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("P", subject.name)
    }

    @Test
    fun testConstruct_whiteRook() {
        subject = Piece(PieceType.ROOK, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("R", subject.name)
    }

    @Test
    fun testConstruct_whiteKnight() {
        subject = Piece(PieceType.KNIGHT, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("N", subject.name)
    }

    @Test
    fun testConstruct_whiteWhiteBishop() {
        subject = Piece(PieceType.WHITE_BISHOP, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("BW", subject.name)
    }

    @Test
    fun testConstruct_whiteQueen() {
        subject = Piece(PieceType.QUEEN, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("Q", subject.name)
    }

    @Test
    fun testConstruct_whiteKing() {
        subject = Piece(PieceType.KING, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("K", subject.name)
    }

    @Test
    fun testConstruct_whiteBlackBishop() {
        subject = Piece(PieceType.BLACK_BISHOP, Side.WHITE)

        assertFalse(subject.isNoPiece)
        assertFalse(subject.isBlack)
        assertTrue(subject.isWhite)
        assertEquals("BB", subject.name)
    }

    @Test
    fun testConstruct_blackPawn() {
        subject = Piece(PieceType.PAWN, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("p", subject.name)
    }

    @Test
    fun testConstruct_blackRook() {
        subject = Piece(PieceType.ROOK, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("r", subject.name)
    }

    @Test
    fun testConstruct_blackKnight() {
        subject = Piece(PieceType.KNIGHT, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("n", subject.name)
    }

    @Test
    fun testConstruct_blackWhiteBishop() {
        subject = Piece(PieceType.WHITE_BISHOP, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("bw", subject.name)
    }

    @Test
    fun testConstruct_blackQueen() {
        subject = Piece(PieceType.QUEEN, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("q", subject.name)
    }

    @Test
    fun testConstruct_blackKing() {
        subject = Piece(PieceType.KING, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("k", subject.name)
    }

    @Test
    fun testConstruct_blackBlackBishop() {
        subject = Piece(PieceType.BLACK_BISHOP, Side.BLACK)

        assertFalse(subject.isNoPiece)
        assertTrue(subject.isBlack)
        assertFalse(subject.isWhite)
        assertEquals("bb", subject.name)
    }
}
