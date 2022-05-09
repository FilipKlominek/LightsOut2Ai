import kotlin.random.Random

class Game {
    val field = Array(5) { arrayOf(true, true, true, true, true) } //creates a 2d array of true

    fun randomize() { //for every cell decides randomly, whether or not to click it (happens before game starts)
        for (i in 0..4) for (j in 0..4) {
            if (Random.nextBoolean()) {
                click(i, j)
                moveCount--
            }
        }
        if (isWon()) randomize() //if every cell is false (1 in 33554432), randomizes again
    }

    fun click(y: Int, x: Int): Boolean {
        if (y > 4 || y < 0 || x > 4 || x < 0) { //check if it's in bounds
            return false
        } else {
            field[y][x] = !field[y][x] //center
            if (y > 0) field[y - 1][x] = !field[y - 1][x] //up
            if (y < 4) field[y + 1][x] = !field[y + 1][x] //down
            if (x > 0) field[y][x - 1] = !field[y][x - 1] //left
            if (x < 4) field[y][x + 1] = !field[y][x + 1] //right
            moveCount++
        }
        return true
    }

    private var moveCount = 0
    fun getMoveCount(): Int {
        return moveCount
    }

    fun isWon(): Boolean { //if any cell is true, returns false, else returns true
        for (i in field) for (j in i) {
            if (j) return false
        }
        return true
    }
}
