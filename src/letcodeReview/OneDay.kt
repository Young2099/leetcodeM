package letcodeReview

import java.util.ArrayList




class OneDay {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val nums = intArrayOf(1, 2, 3)
//            val list = getList(nums)
//            for (i in list) {
//                println(i)
//            }
//            println(2 % 3)
        }

        private fun getList(nums: IntArray): ArrayList<ArrayList<Int>> {
            val res: ArrayList<ArrayList<Int>> = ArrayList()
            res.add(ArrayList())
            for (elements in nums) {
                val size = res.size
                for (j in 0 until size) {
                    val list: ArrayList<Int> = ArrayList<Int>(res[j])
                    //然后在新的子集后面追加这个元素
                    list.add(elements)
                    //把这个新的子集添加到集合中
                    res.add(list)
                }
            }
            return res
        }

    }
}