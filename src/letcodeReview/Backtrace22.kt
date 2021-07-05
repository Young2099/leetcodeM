package letcodeReview

/**
 * 输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
 */
class Backtrace22 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val path = String()
            val res = ArrayList<String>()
            dfs(2, path, res, 0, 0)
            println(res)
        }

        private fun dfs(n: Int, path: String, res: java.util.ArrayList<String>, open: Int, close: Int) {
//            if (open > n || close > open) return;
            if (path.length == 2 * n) {
                res.add(path)
                return
            }
                if(open < n) {
                    dfs(n, "$path(", res, open + 1, close)
                }
                if(close < open) {
                    dfs(n, "$path)", res, open, close + 1)
                }

        }
    }
}