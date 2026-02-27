import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

var diff = Int.MAX_VALUE
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = br.readLine().toInt()

    val statuses = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val visited = BooleanArray(n)

    dfs(0, 0, statuses, visited)

    print(diff)
}

fun dfs(
    idx: Int,
    count: Int,
    status: Array<List<Int>>,
    visited: BooleanArray
) {
    if (count == n / 2) {
        var aTeam = 0
        var bTeam = 0
        for (i in 0..n - 1) {
            for (j in 0..n - 1) {
                if (i == j || visited[i] != visited[j]) continue
                if (visited[i]) aTeam += status[i][j]
                else bTeam += status[i][j]
            }
        }
        diff = min(diff, abs(aTeam - bTeam))
        return
    }
    for (i in idx..n - 1) {
        visited[i] = true
        dfs(i + 1, count + 1, status, visited)
        visited[i] = false
    }
}