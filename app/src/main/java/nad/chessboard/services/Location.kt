package nad.chessboard.services

/**
 * Location (i, j) is column ("file"), and row ("rank), starting from 1,1 (a1),
 * the left file of the first row of White's side, ending at 8,8 (h8),
 * the right file (from White's point of view) of Black's first row.
 */
class Location(val column: Int, val row: Int) {
    val isBlack
        get() = !isWhite

    val isWhite
        get() = column % 2 == row % 2

    override fun equals(other: Any?): Boolean {
        return (other as? Location)?.let { otherLocation ->
            otherLocation.column == column && otherLocation.row == this.row
        } ?: false
    }

    fun generateSquareOfProperColor(): Square {
        return when {
            isWhite -> Square(Side.WHITE, NoPiece)
            else -> Square(Side.BLACK, NoPiece)
        }
    }

    override fun hashCode(): Int = column.hashCode() xor row.hashCode()

    override fun toString(): String {
        val columnName = when (column) {
            1 -> "a"
            2 -> "b"
            3 -> "c"
            4 -> "d"
            5 -> "e"
            6 -> "f"
            7 -> "g"
            8 -> "h"
            else -> "$column:"
        }

        return "$columnName$row"
    }
}
