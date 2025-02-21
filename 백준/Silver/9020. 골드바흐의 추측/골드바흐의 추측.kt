import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()){
    val n : Int = readLine().toInt()
    val arr = ArrayList<Int>()
    var max = 0
    for (i in 1..n) {
        val num : Int = readLine().toInt()
        arr.add(num)
        max = maxOf(max, num)
    }

    val isPrime = BooleanArray(max + 1)
    isPrime[0] = true
    isPrime[1] = true

    for (i in 2..sqrt(max.toDouble()).toInt()) {
        if (!isPrime[i]) {
            for (j in i * i..max step i) {
                isPrime[j] = true
            }
        }
    }

    for (t in arr) {
        for (i in t / 2.. t - 2) {
            if (!isPrime[i] && !isPrime[t - i]) {
                println("${t - i} $i")
                break
            }
        }
    }
}