fun main() = with(System.`in`.bufferedReader()){
    val n : Int = readLine().toInt()
    var count = 0
    repeat(n) {
        if (readLine().split("-")[1].toInt() <= 90) {
            count++
        }
    }
    print(count)
}