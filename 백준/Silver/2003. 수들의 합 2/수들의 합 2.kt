import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val st = StringTokenizer(readLine())
    val arr = Array(n) {st.nextToken().toInt()}

    var start = 0
    var end = 1
    var sum = arr[0]
    var res = 0
    while (true) {
        if (sum == m) {
            res++
            sum -= arr[start++]
        } else if (sum < m) {
            if (end == n) {
                break
            }
            sum += arr[end++]
        } else {
            sum -= arr[start++]
        }
    }

    print(res)
}