package letcodeReview

/**
 * 46题目
 *  [1,2,3]
 */
class Permute {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1, 1, 2)
            val res: ArrayList<ArrayList<Int>> = ArrayList()
            val path: ArrayList<Int> = ArrayList()
            val used   = BooleanArray(nums.size)
            dfs(nums, -1, res, path,used)
            for (i in res.iterator()) {
                println(i)
            }
        }
        fun dfs(nums: IntArray, index: Int, res: ArrayList<ArrayList<Int>>, path: ArrayList<Int>, used: BooleanArray){
            if(path.size == nums.size ){
                res.add(ArrayList(path))
                return
            }
            for (i in  nums.indices){
                if(used[i]){
                    continue
                }
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue
                }
                path.add(nums[i])
                used[i] = true
                dfs(nums,index,res,path,used)
                used[i] = false
                path.removeAt(path.size-1)

            }
        }


    }
}