class Solution {
    fun solution(cards: IntArray): Int {
        var first = 0
        var second = 0
        
        val visited = Array(cards.size) {false}
        for (i in 0..visited.size - 1) {
            if (visited[i]) continue
            val count = dfs(i, 0, visited, cards)
            if (count > first) {
                second = first
                first = count
            } else if (count > second) {
                second = count
            }
        }
        return first * second
    }
    
    fun dfs(idx: Int, c: Int, visited: Array<Boolean>, cards: IntArray): Int {
        visited[idx] = true
        if (visited[cards[idx] - 1]) return c + 1
        return dfs(cards[idx] - 1, c + 1, visited, cards)
    }
}