//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    //用两个栈实现队列：栈是先进后出，队列是先进先出
    Deque<Integer> inStack;
    Deque<Integer> outStack;


    public CQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    //新元素直接放入输入栈，instack
    public void appendTail(int value) {
        inStack.push(value);
    }


    //删除时，需要先将inStack中元素依次弹出到outStack，然后从输出栈outStack删除
    public int deleteHead() {
        if(outStack.isEmpty()){
            if(inStack.isEmpty()){
                return -1;
            }
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
       return outStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
