package nad.chessboard.services

import nad.chessboard.services.Side.BLACK
import nad.chessboard.services.Side.WHITE
import nad.chessboard.services.PieceType.ROOK
import nad.chessboard.services.PieceType.KNIGHT
import nad.chessboard.services.PieceType.BLACK_BISHOP
import nad.chessboard.services.PieceType.WHITE_BISHOP
import nad.chessboard.services.PieceType.QUEEN
import nad.chessboard.services.PieceType.KING
import nad.chessboard.services.PieceType.PAWN

class Board {
    private val locations: MutableSet<Location> = createLocations()
    private val squares: MutableMap<Location, Square> = createSquares()

    fun at(column: Int, row: Int): Square? = locationAt(column, row)?.let { squares[it] }

    fun atPut(column: Int, row: Int, piece: PieceInterface) {
        at(column, row)?.let { it.piece = piece }
    }

    fun resetToStartingPosition() {
        squares.values.forEach { it.becomeEmpty() }

        // White
        atPut(1, 1, Piece(ROOK, WHITE))
        atPut(2, 1, Piece(KNIGHT, WHITE))
        atPut(3, 1, Piece(WHITE_BISHOP, WHITE))
        atPut(4, 1, Piece(QUEEN, WHITE))
        atPut(5, 1, Piece(KING, WHITE))
        atPut(6, 1, Piece(BLACK_BISHOP, WHITE))
        atPut(7, 1, Piece(KNIGHT, WHITE))
        atPut(8, 1, Piece(ROOK, WHITE))
        atPut(1, 2, Piece(PAWN, WHITE))
        atPut(2, 2, Piece(PAWN, WHITE))
        atPut(3, 2, Piece(PAWN, WHITE))
        atPut(4, 2, Piece(PAWN, WHITE))
        atPut(5, 2, Piece(PAWN, WHITE))
        atPut(6, 2, Piece(PAWN, WHITE))
        atPut(7, 2, Piece(PAWN, WHITE))
        atPut(8, 2, Piece(PAWN, WHITE))

        // Black
        atPut(1, 8, Piece(ROOK, BLACK))
        atPut(2, 8, Piece(KNIGHT, BLACK))
        atPut(3, 8, Piece(BLACK_BISHOP, BLACK))
        atPut(4, 8, Piece(QUEEN, BLACK))
        atPut(5, 8, Piece(KING, BLACK))
        atPut(6, 8, Piece(WHITE_BISHOP, BLACK))
        atPut(7, 8, Piece(KNIGHT, BLACK))
        atPut(8, 8, Piece(ROOK, BLACK))
        atPut(1, 7, Piece(PAWN, BLACK))
        atPut(2, 7, Piece(PAWN, BLACK))
        atPut(3, 7, Piece(PAWN, BLACK))
        atPut(4, 7, Piece(PAWN, BLACK))
        atPut(5, 7, Piece(PAWN, BLACK))
        atPut(6, 7, Piece(PAWN, BLACK))
        atPut(7, 7, Piece(PAWN, BLACK))
        atPut(8, 7, Piece(PAWN, BLACK))
    }

    private fun createSquares(): MutableMap<Location, Square> =
        mutableMapOf<Location, Square>().apply {
            locations.forEach { this[it] = it.generateSquareOfProperColor() }
        }

    private fun createLocations(): MutableSet<Location> =
        mutableSetOf<Location>().apply {
            for (column in 1..8) {
                for (row in 1..8) {
                    this.add(Location(column, row))
                }
            }
        }

    private fun locationAt(column: Int, row: Int): Location? = locations.find { it.column == column && it.row == row }
}
