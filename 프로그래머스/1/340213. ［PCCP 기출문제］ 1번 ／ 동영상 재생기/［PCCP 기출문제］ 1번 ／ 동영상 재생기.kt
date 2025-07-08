import java.text.DecimalFormat

class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer: String = ""
        val len = getIntTime(video_len)
        val start = getIntTime(op_start)
        val end = getIntTime(op_end)
        var cur = getIntTime(pos)
        commands.forEach {
            if (cur >= start && cur <= end) cur = end
            if (it == "next") cur = Math.min(cur + 10, len)
            else cur = Math.max(cur - 10, 0)
        }
        if (cur >= start && cur <= end) cur = end
        cur = Math.min(cur, len)
        return getStringTime(cur)
    }
    
    fun getIntTime(time:String): Int {
        val times = time.split(":")
        return times[0].toInt() * 60 + times[1].toInt()
    }
    
    fun getStringTime(time:Int): String {
        val df = DecimalFormat("00")
        var m = df.format(time / 60)
        var s = df.format(time % 60)
        return "$m:$s"
    }
}