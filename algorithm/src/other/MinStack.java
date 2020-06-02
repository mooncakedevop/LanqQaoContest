package other;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: _1
 * @description: 最小栈
 * @author: mooncake
 * @create: 2020-05-14 08:09
 **/
class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> queue;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
        new Thread(()->{

        }).start();
    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
        Integer i = stack.pop();
        queue.remove(i);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */