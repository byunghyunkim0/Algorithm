import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    val n : Int = readLine().toInt()
    var st : StringTokenizer
    val sb : StringBuilder = StringBuilder()
    repeat(n) {
        st = StringTokenizer(readLine(), ",")
        sb.append(st.nextToken().toInt() + st.nextToken().toInt()).append("\n")
    }
    print(sb)
}