package letcodeReview

import java.util.*
import kotlin.collections.ArrayList

/**
 *  

示例：
输入：S = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入：S = "3z4"
输出：["3z4", "3Z4"]

输入：S = "12345"
输出：["12345"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BackTrace784 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "a1b2"
            val res = ArrayList<String>()
            val path = Stack<String>()
            val arrays = s.toCharArray()
            dfs(arrays,0,res,path)
        }

        private fun dfs(s: CharArray, index:Int, res: java.util.ArrayList<String>, path: Stack<String>) {

        }
    }
}