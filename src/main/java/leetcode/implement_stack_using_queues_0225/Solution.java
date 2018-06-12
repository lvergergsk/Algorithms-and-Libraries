package leetcode.implement_stack_using_queues_0225;

import java.util.Deque;
import java.util.LinkedList;

class MyStack {

    Deque<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
//        3 2 1 -> 3 2 1 4 -> 2 1 4 3 -> 1 4 3 2 -> 4 3 2 1
        this.queue.addLast(x);
        for (int i = 0, size = queue.size(); i < size - 1; i++) queue.addLast(queue.removeFirst());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return this.queue.removeFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.queue.peekFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "queue=" + queue +
                '}';
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */