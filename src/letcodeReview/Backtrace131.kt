package letcodeReview

import java.util.*
import kotlin.collections.ArrayList

class Backtrace131 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "aab"
            val res = ArrayList<String>()
            val temp = LinkedList<String>()
            dfs(s, 0, temp, res)
            for (i in res.iterator()){
                println(i)
            }
        }

        fun dfs(s: String, start: Int, temp: LinkedList<String>, res: ArrayList<String>) {
            if (start == s.length ) {
                res.add(temp.toString())
                return
            }

            for (i in 1 until s.length) {
                if(start+i- 1 >= s.length){
                    return
                }
//                if (!checkPalindrome(s, start, i)) {
//                    continue
//                }
                val str = s.substring(start, start+i)
                temp.addLast(str)
                dfs(s, start+i, temp, res)
                temp.removeLast()

            }

        }

        private fun checkPalindrome(s: String, start: Int, i: Int): Boolean {
            var left = start
            var right = i
            while (left <right){
                if(s[left] != s[right]){
                    return false
                }
                left++
                right--
            }
            return true
        }
    }
}