package leetcode.implement_stack_using_queues_0225;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {
    MyStack myStack;

    @Before
    public void before() {
        myStack = new MyStack();
    }

    @Test
    public void stackTest01() {
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.pop());
        assertFalse(myStack.empty());
    }
}