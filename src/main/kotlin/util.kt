import java.io.File

fun calculateThreadsStatistics(file: File): Map<String, Int> {
    val threadsStatistics = mutableMapOf<String, Int>()
    file.forEachLine { line ->
        val parts = line.split(Regex("\\s+"))
        val threadName = parts[5]
        threadsStatistics[threadName] = threadsStatistics.getOrPut(threadName) { 0 } + 1
    }
    return threadsStatistics
}

fun takeTopK(threadsStatistics: Map<String, Int>, limit: Int): List<Map.Entry<String, Int>> {
    return threadsStatistics.toSortedMap(compareByDescending<String> { threadsStatistics[it] }.thenBy { it })
        .entries
        .take(limit)
}
