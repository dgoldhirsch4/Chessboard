package nad.chessboard.services

class Square(val side: Side, var piece: PieceInterface) {
    val isEmpty
        get() = piece.isNoPiece

    val isBlack
        get() = !isWhite

    val isWhite
        get() = side == Side.WHITE

    fun becomeEmpty() {
        piece = NoPiece
    }

    override fun toString(): String {
        return when {
            isEmpty -> "$side"
            else -> "$side square containing: $piece"
        }
    }
}
