package letcodeReview

class MyCircleQueue(a: Int) {

    //队列容量
    private val capticy: Int = a

    //利用两个指标来表示所移动到的点，head表示头
    private var headIndex = 0

    //last表示末尾 如果head == last 则说明 数组为null ，设计原理是你追我赶，数组的容量在限定范围内
    //当last +1 取模与 capcity的时候，说明数组也就是队列为null追赶上了，，
    private var lastIndex = 0
    private val mQueue: IntArray = IntArray(a)

    //添加进循环队列
    private fun addQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        mQueue[lastIndex] = value
        //取模是为了删除元素之后的插入元素，在限定的数组范围大小内
        lastIndex = (lastIndex + 1) % capticy
        return true
    }

    private fun deleteQueue(): Boolean {
        if(isEmpty()){
            return false
        }
        headIndex = (headIndex + 1) % capticy
        return true
    }

    private fun isEmpty(): Boolean {
        return headIndex == lastIndex
    }

    private fun isFull(): Boolean {
        //多一个来形成环
        return (lastIndex + 1) % capticy == headIndex
    }

    //最开始的元素
    private fun rear(): Int {
        return mQueue[headIndex % capticy]
    }

    private fun last():Int{
        return mQueue[(lastIndex - 1 + capticy) % capticy]
    }

}