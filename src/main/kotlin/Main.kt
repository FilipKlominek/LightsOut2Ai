fun main() {

    println("Is a human playing?")
    val isPlayerPlaying = readLine()!!.toBoolean()

    if (isPlayerPlaying) {
        val player: Player = Player()
        player.play()
    } else {
        val ai: AI = AI()
        ai.play()
    }
}
