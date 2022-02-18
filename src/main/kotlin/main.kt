import java.io.File

fun main(args: Array<String>) {
    println("Enter path to your log file")
    val pathToFile = readLine()
    if (pathToFile == null) {
        println("Not a path to file!")
        return
    }
    val threadsStatistics = calculateThreadsStatistics(File(pathToFile))
    for (entry in takeTopK(threadsStatistics, 10)) {
        println("${entry.key} ${entry.value}")
    }
}
