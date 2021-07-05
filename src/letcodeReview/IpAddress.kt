package letcodeReview

import java.util.*
import kotlin.collections.ArrayList

/**
 * 输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
 */
class IpAddress {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "25525511135"
            val path = LinkedList<String>()
            val res = ArrayList<String>()
            dfs(s, 0, path, res)
            println(res)
        }

        private fun dfs(s: String, start: Int, path: LinkedList<String>, res: ArrayList<String>) {
            if(start == s.length && path.size == 4 ){
                res.add(path.toString())
                return
            }
            if(start < s.length && path.size == 4) {
                return
            }
            for (i in 1 until 4) {
                if(start+i-1 >= s.length){
                    return
                }
                //意思就是ip第一个可以为0，但是后面的开始不能为0
                if(i != 1 && s[start] =='0'){
                    return
                }
                val str = s.substring(start, start + i)
                if (str.length == 3 && str.toInt() > 255) {
                    continue
                }
                path.addLast(str)
                dfs(s, start + i, path, res)
                path.removeLast()
            }
        }
    }
}