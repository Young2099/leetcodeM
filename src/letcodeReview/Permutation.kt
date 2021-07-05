package letcodeReview

import java.util.*
import kotlin.collections.ArrayList

class Permutation {
    /**
     * 找到数和为7的数组list
     */
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(2, 3, 6, 7)
            val target = 7
            val path: Stack<Int> = Stack()
            val res: ArrayList<ArrayList<Int>> = ArrayList()
            dfs(nums, 0, path, res, target)
            for (i in res.iterator()){
                println(i)
            }
        }

        /**
         * 深度优先
         */
        private fun dfs(
            nums: IntArray,
            index: Int,
            path: Stack<Int>,
            res: java.util.ArrayList<java.util.ArrayList<Int>>,
            target: Int
        ) {
            if (target == 0) {
                res.add(ArrayList(path))
            }
            for (i in index until nums.size ) {
                if (nums[i] > target) {
                    break
                }
                path.add(nums[i])
                dfs(nums, i, path, res, target - nums[i])
                path.removeLast()
            }


        }

    }
}