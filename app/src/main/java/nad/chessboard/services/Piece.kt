package nad.chessboard.services

import nad.chessboard.services.PieceType.ROOK
import nad.chessboard.services.PieceType.KNIGHT
import nad.chessboard.services.PieceType.BLACK_BISHOP
import nad.chessboard.services.PieceType.WHITE_BISHOP
import nad.chessboard.services.PieceType.QUEEN
import nad.chessboard.services.PieceType.PAWN

class Piece(val pieceType: PieceType, val side: Side): PieceInterface {
    val isBlack
        get() = side == Side.BLACK

    override val isNoPiece
        get() = false

    val isWhite
        get() = !isBlack

    val name: String
        get() {
            var letter = when(pieceType) {
                PAWN -> "P"
                ROOK -> "R"
                KNIGHT -> "N"
                BLACK_BISHOP -> "BB"
                WHITE_BISHOP -> "BW"
                QUEEN -> "Q"
                else -> "K"
            }

            if (isBlack) {
                letter = letter.toLowerCase()
            }

            return letter
        }

    override fun equals(other: Any?): Boolean {
        return (other as? Piece)?.let {
            it.pieceType == this.pieceType && it.side == this.side
        } ?: false
    }

    override fun hashCode() = pieceType.hashCode() xor side.hashCode()

    override fun toString() = name
}
