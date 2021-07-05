package letcodeReview

import com.sun.org.apache.bcel.internal.generic.IFEQ

/**
 *
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

示例:

输入: 2
输出: 91
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
class CountNumbersWithUnique357 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = dfs(3)
//            val 81*8 =
            println(a)
        }

        fun dfs(n: Int): Int {
            if(n == 0) return 1
            var first = 10
            var ans = 9
            var second = 81
            if(n== 1) return first
            for (i in 2 .. n){
                println(i)
                first+=second
                second *= (10  - i)

            }
            return  first
        }


    }
}